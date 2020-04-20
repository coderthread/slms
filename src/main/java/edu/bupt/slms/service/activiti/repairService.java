package edu.bupt.slms.service.activiti;

import edu.bupt.slms.bean.Error;
import edu.bupt.slms.bean.*;
import edu.bupt.slms.mapper.ErrorMapper;
import edu.bupt.slms.mapper.LightMapper;
import edu.bupt.slms.mapper.ReceiptMapper;
import edu.bupt.slms.mapper.RepairBillMapper;
import edu.bupt.slms.service.AccountService;
import edu.bupt.slms.service.ErrorService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/05 22:28:34
 */
@Service
public class repairService {

    @Autowired
    RuntimeService runtimeService;
    @Autowired
    AccountService accountService;
    @Autowired
    ErrorService errorService;
    @Autowired
    ErrorMapper errorMapper;
    @Autowired
    RepairBillMapper repairBillMapper;
    @Autowired
    ReceiptMapper receiptMapper;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    LightMapper lightMapper;

    public void alarm(DelegateExecution execution) {
        String key = execution.getProcessInstanceBusinessKey();
        Error error = errorService.getErrorId(Integer.valueOf(key));
        // 更改地图中light的状态为故障
        if (error.getLightId() != null){
            Light light = new Light();
            light.setId(error.getLightId());
            light.setStatus("故障");
            lightMapper.updateByPrimaryKeySelective(light);
        }
        // 查出故障信息放到消息队列，给谁发邮件先写死，待定
        rabbitTemplate.convertAndSend("slms.mail.errorAlarm",error);
    }

    public void autoDis(DelegateExecution delegateExecution) {
        // 1. 先简单处理获取所有的维修人员，分配给第一个
        Account account = new Account();
        List<RespAccount> maintainers = accountService.getAccountsByRoleNameZh("维修人员",account);
        String errorId = delegateExecution.getProcessInstanceBusinessKey();
        Integer maintainer = maintainers.get(0).getId();
        runtimeService.setVariable(delegateExecution.getId(), "maintainer", maintainer);
        // 2. error 表中添加id 和 aId 根据id 添加 aId
        Error error = new Error();
        error.setId(Integer.valueOf(errorId));
        error.setaId(maintainer);
        error.setStatus("ready");
        errorService.updateError(error);
    }

    public void createBill(DelegateExecution delegateExecution) {
        /**
         * ②维修人员同意接受任务并生成工单，也就是在工单列表中插入一项,并且修改error的状态status#{ActivityDemoServiceImpl.insertRepairBill(execution,error)}
         * @param delegateExecution
         * @param
         */
        //获取故障id
        String key = delegateExecution.getProcessInstanceBusinessKey();
        System.out.println(key);

        //增加工单项
        Error error = errorMapper.selectByPrimaryKey( Integer.valueOf(key));
        Receipt receipt = new Receipt();
        receipt.setAccountId(error.getaId());
        receipt.setErrorId(error.getId());
        receipt.setStartTime(new Date());
        receiptMapper.insertSelective(receipt);
        //修改error状态
        error.setStatus("fixing");
        errorMapper.updateByPrimaryKeySelective(error);

        System.out.println("生成工单！");
    }


    /**
     * 更新回单
     */
    public int RepairComplete(Receipt receipt ){

        receipt.setEndTime(new Date());

        int result1 = receiptMapper.updateByErrorIdSelective(receipt);
        Error error = errorService.getErrorId(receipt.getErrorId());
        // 更改error的状态为已完成
        error.setStatus("finished");
        int result2 = errorMapper.updateByPrimaryKeySelective(error);
        //将修好灯的状态改为工作中
        Light light = new Light();
        light.setId(error.getLightId());
        light.setStatus("工作中");
        int result3 = lightMapper.updateByPrimaryKeySelective(light);
        return result1 + result2 + result3;

    }


}

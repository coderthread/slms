package edu.bupt.slms.service.activiti;

import edu.bupt.slms.bean.*;
import edu.bupt.slms.bean.Error;
import edu.bupt.slms.mapper.ErrorMapper;
import edu.bupt.slms.mapper.ReceiptMapper;
import edu.bupt.slms.mapper.RepairBillMapper;
import edu.bupt.slms.service.AccountService;
import edu.bupt.slms.service.ErrorService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void alarm(DelegateExecution execution) {
        // 故障报警是不是要用消息中间件或邮箱等服务
        String key = execution.getProcessInstanceBusinessKey();
        System.out.println(key);
        boolean auto = (boolean) execution.getVariable("auto");
        System.out.println(auto);
        System.out.println("流程实例为>>>>>>>>>>>>"+execution.toString());
    }

    public void autoDis(DelegateExecution delegateExecution) {
        // 1. 先简单处理获取所有的维修人员，分配给第一个
        List<Account> maintainers = accountService.getAccountsByRoleNameZh("维修人员");
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
        RepairBill repairbill = new RepairBill();
        repairbill.setaId(error.getaId());
        repairbill.seteId(error.getId());
        repairbill.setStartTime(error.getDate());
        //在error中找不到工单的时限。
        repairbill.setTimeLimit(3);
        repairBillMapper.insert(repairbill);
        //修改error状态
        error.setStatus("fixing");
        errorMapper.updateByPrimaryKey(error);

        System.out.println("生成工单！");
    }


    /**
     * ⑤维修人员维修完成并填写回单，也就是在Receipt表中新增一项,并且修改error中的状态status#{ActivityDemoServiceImpl.refuseToRepair(execution,error)}
     * @param receipt
     * @return
     */
    public RespBean RepairComplete(Receipt receipt ){

        try {
            //更新error状态
            Integer eId = receipt.getErrorId();
            Error error = errorMapper.selectByPrimaryKey(eId);
            error.setStatus("finished");
            errorMapper.updateByPrimaryKey(error);
             //插入回单项
            receiptMapper.insertSelective(receipt);
            return RespBean.ok("创建回单成功");
        }catch(Exception e){
            e.printStackTrace();
        }
        return RespBean.error("创建回单失败");

    }


}

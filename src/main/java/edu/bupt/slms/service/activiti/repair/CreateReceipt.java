package edu.bupt.slms.service.activiti.repair;

import edu.bupt.slms.bean.Error;
import edu.bupt.slms.bean.Receipt;
import edu.bupt.slms.mapper.ErrorMapper;
import edu.bupt.slms.mapper.ReceiptMapper;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CreateReceipt {
    @Autowired
    ReceiptMapper receiptMapper;
    @Autowired
    ErrorMapper errorMapper;


    public List<String> findUsersForWX(DelegateExecution delegateExecution){

        //做这些是为了修改error状态为complete
        //获取故障id
        String key = delegateExecution.getProcessInstanceBusinessKey();
        System.out.println(key);
        //增加工单项
        Error error = errorMapper.selectByPrimaryKey( Integer.valueOf(key));
        error.setStatus("complete");
        errorMapper.updateByPrimaryKey(error);

        //返回assignee
        return Arrays.asList("uspy2");
    }

    /**
     * ⑤维修人员维修完成并填写回单，也就是在Receipt表中新增一项,并且修改error中的状态status#{ActivityDemoServiceImpl.refuseToRepair(execution,error)}
     * @param receipt
     */
    public Boolean RepairComplete( Receipt receipt ){

        boolean flag=false;
        try {
             /*error.setStatus("completed");
            errorMapper.updateByPrimaryKey(error);*/
            receiptMapper.insertSelective(receipt);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;

    }
}

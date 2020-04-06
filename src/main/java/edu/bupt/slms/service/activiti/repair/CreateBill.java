package edu.bupt.slms.service.activiti.repair;
import edu.bupt.slms.bean.Error;
import edu.bupt.slms.bean.RepairBill;
import edu.bupt.slms.mapper.ErrorMapper;
import edu.bupt.slms.mapper.RepairBillMapper;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author: 韩 宁
 * @create: 2020/04/04 18:13:50
 */
public class CreateBill implements Serializable, JavaDelegate {


    @Autowired
    private ErrorMapper errorMapper;
    @Autowired
    private RepairBillMapper repairBillMapper;


    @Override
    public void execute(DelegateExecution delegateExecution) {

    }



}

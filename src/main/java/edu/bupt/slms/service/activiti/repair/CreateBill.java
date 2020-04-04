package edu.bupt.slms.service.activiti.repair;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import java.io.Serializable;

/**
 * @author: 韩 宁
 * @create: 2020/04/04 18:13:50
 */
public class CreateBill implements Serializable, JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("生成工单！");
    }
}

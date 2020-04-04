package edu.bupt.slms.service.activiti.repair;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import java.io.Serializable;

/**
 * @author: 韩 宁
 * @create: 2020/04/04 18:11:20
 */
public class AutoDis implements Serializable, JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("autoDis>>>>>>>>>>>>>>>>>");
    }
}

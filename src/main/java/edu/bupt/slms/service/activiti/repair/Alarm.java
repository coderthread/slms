package edu.bupt.slms.service.activiti.repair;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author: 韩 宁
 * @create: 2020/04/04 17:20:00
 */
public class Alarm implements Serializable, JavaDelegate {
    @Autowired
    RuntimeService runtimeService;
    @Override
    public void execute(DelegateExecution delegateExecution) {
        String key = delegateExecution.getProcessInstanceBusinessKey();
        System.out.println(key);
        System.out.println("流程实例为>>>>>>>>>>>>"+this.toString());
    }
}

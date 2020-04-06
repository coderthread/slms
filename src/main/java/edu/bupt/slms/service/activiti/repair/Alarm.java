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
        // 故障报警是不是要用消息中间件或邮箱等服务
        String key = delegateExecution.getProcessInstanceBusinessKey();
        System.out.println(key);
        boolean auto = (boolean) delegateExecution.getVariable("auto");
        System.out.println(auto);
        System.out.println("流程实例为>>>>>>>>>>>>"+delegateExecution.toString());
    }
}

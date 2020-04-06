package edu.bupt.slms.service.activiti.repair;

import edu.bupt.slms.bean.Account;
import edu.bupt.slms.bean.Error;
import edu.bupt.slms.service.AccountService;
import edu.bupt.slms.service.ErrorService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/04 18:11:20
 */
public class AutoDis implements Serializable, JavaDelegate {
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    AccountService accountService;
    @Autowired
    ErrorService errorService;

    @Override
    public void execute(DelegateExecution delegateExecution) {

    }
}

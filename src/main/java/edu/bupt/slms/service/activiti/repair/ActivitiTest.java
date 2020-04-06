package edu.bupt.slms.service.activiti.repair;

import edu.bupt.slms.bean.Account;
import edu.bupt.slms.service.AccountService;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/05 22:22:59
 */
@Service
public class ActivitiTest {
    @Autowired
    AccountService accountService;

    public void select(DelegateExecution execution) {
        System.out.println("------------------");
        List<Account> accounts = accountService.getAccountsByRoleNameZh("维修人员");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}

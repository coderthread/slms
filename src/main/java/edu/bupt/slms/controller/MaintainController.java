package edu.bupt.slms.controller;

import edu.bupt.slms.bean.Account;
import edu.bupt.slms.bean.Error;
import edu.bupt.slms.service.ErrorService;
import edu.bupt.slms.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/05 17:09:56
 */
@RestController
@RequestMapping("/maintain")
public class MaintainController {
    @Autowired
    ErrorService errorService;

    /**
     * 获取当前维修人员所负责的任务
     * @return
     */
    @GetMapping("/")
    public List<Error> getError() {
        Account account = AccountUtils.getCurrentAccount();
        return errorService.getErrorByaId(account.getId());
    }
}

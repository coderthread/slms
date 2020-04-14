package edu.bupt.slms.controller;

import edu.bupt.slms.bean.*;
import edu.bupt.slms.bean.Error;
import edu.bupt.slms.service.AccountService;
import edu.bupt.slms.service.ErrorService;
import edu.bupt.slms.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/05 18:37:35
 */
@RestController
@RequestMapping("/fault/info")
public class ErrorController {
    @Autowired
    ErrorService errorService;
    @Autowired
    SystemConfigService systemConfigService;
    @Autowired
    AccountService accountService;

    @GetMapping("/")
    public RespPageBean getErrorByPage(@RequestParam(defaultValue = "false") Boolean part,
                                       @RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "10") Integer size,
                                       Error error, Date[] dateScope) {
        return errorService.getErrorByPage(part,page, size, error, dateScope);
    }

    @GetMapping("/auto/")
    public SystemConfig getSystemCfg(){
        return systemConfigService.getSystemCfg();
    }

    @PutMapping("/auto/")
    public RespBean updateAuto(@RequestBody SystemConfig systemConfig){
        if (systemConfigService.updateConfigService(systemConfig) == 1){
            return RespBean.ok("分配方式修改成功！");
        }
        return RespBean.error("分配方式修改失败！");
    }

    @GetMapping("/account/")
    public List<RespAccount> getMaintainers(Account account){
        return accountService.getAccountsByRoleNameZh("维修人员",account);
    }

}

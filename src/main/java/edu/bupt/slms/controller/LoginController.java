package edu.bupt.slms.controller;

import edu.bupt.slms.bean.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 韩 宁
 * @create: 2020/03/19 18:23:58
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录，请登录！");
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello 测试成功";
    }
}

package edu.bupt.slms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 韩 宁
 * @create: 2020/03/22 08:49:22
 */
@RestController
public class TestController {

    @GetMapping("/fault/dis/")
    public String Hello1(){
        return "哥们，你真棒！";
    }

    @GetMapping("fault/info/")
    public String hello2(){
        return "小伙子，那你能行的！";
    }
}

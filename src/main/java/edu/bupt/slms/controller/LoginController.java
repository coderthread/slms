package edu.bupt.slms.controller;

import edu.bupt.slms.bean.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 韩 宁
 * @create: 2020/03/19 18:23:58
 */
@RestController
@Api(tags = "登录接口")
public class LoginController {

    @ApiOperation(value = "提示尚未登录")
    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录，请登录！");
    }

}

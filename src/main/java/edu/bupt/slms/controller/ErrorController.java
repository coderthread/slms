package edu.bupt.slms.controller;

import edu.bupt.slms.bean.Error;
import edu.bupt.slms.bean.RespPageBean;
import edu.bupt.slms.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/05 18:37:35
 */
@RestController
@RequestMapping("/fault")
public class ErrorController {
    @Autowired
    ErrorService errorService;

    @GetMapping("/")
    public List<Error> getErrorByPage() {
        return errorService.getErrors();
    }



}

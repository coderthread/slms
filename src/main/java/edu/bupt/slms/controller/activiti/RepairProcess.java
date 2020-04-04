package edu.bupt.slms.controller.activiti;

import edu.bupt.slms.bean.RespBean;
import edu.bupt.slms.service.activiti.repair.Alarm;
import edu.bupt.slms.service.activiti.repair.AutoDis;
import edu.bupt.slms.service.activiti.repair.CreateBill;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 韩 宁
 * @create: 2020/04/04 17:55:09
 */
@RestController
@RequestMapping("/repair")
public class RepairProcess {
    @Autowired
    RuntimeService runtimeService;

    @GetMapping("/")
    public RespBean addError() {
        Map<String,Object> map = new HashMap<>();
        map.put("alarm",new Alarm());
        map.put("autoDis",new AutoDis());
        map.put("createBill",new CreateBill());
        map.put("auto",true);
        ProcessInstance holiday = runtimeService.startProcessInstanceByKey("repair","1001",map);
        return RespBean.ok("完成报警");
    }
}

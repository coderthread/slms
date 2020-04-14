package edu.bupt.slms.controller.activiti;

import edu.bupt.slms.bean.Error;
import edu.bupt.slms.bean.Receipt;
import edu.bupt.slms.bean.RespBean;
import edu.bupt.slms.service.ErrorService;
import edu.bupt.slms.service.SystemConfigService;
import edu.bupt.slms.service.activiti.repairService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 韩 宁
 * @create: 2020/04/04 17:55:09
 */
@RestController
public class RepairProcess {
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private repairService rs;
    @Autowired
    ErrorService errorService;
    @Autowired
    SystemConfigService systemConfigService;


    /**
     * 韩宁
     * 接受错误并创建实例
     */
    @PostMapping("/repair/")
    public RespBean addError(@RequestBody Error error) {
        // 1. 存错error信息
        error.setStatus("unDistribution");
        if (errorService.addError(error) != 1) {
            return RespBean.error("添加失败！");
        }
        // 2. 在系统设置表中获取auto
        Boolean auto = systemConfigService.getSystemCfg().getAutoDistribution();
        // 3. 启动流程实例
        Map<String, Object> map = new HashMap<>();
        map.put("auto", auto);
        ProcessInstance holiday = runtimeService.startProcessInstanceByKey("repair", String.valueOf(error.getId()), map);
        return RespBean.ok("完成报警");
    }

    /**
     * 韩宁
     * 管理员手动分配
     * @param eId  所选故障Id
     * @param aId  维修人员Id
     * @return
     */
    @GetMapping("/fault/dis/manual")
    public RespBean manualDistribution(Integer eId, Integer aId) {
        // 根据eId查到该任务
        Task task = taskService.createTaskQuery()
                .processInstanceBusinessKey(String.valueOf(eId))
                .taskName("管理员分配")
                .singleResult();
        // 查询不到直接返回
        if (task == null) {
            return RespBean.error("没有该任务");
        }
        // 设置${maintainer}
        taskService.setVariable(task.getId(),"maintainer",aId);
        // 2. error 表中添加id 和 aId 根据id 添加 aId
        Error error = new Error();
        error.setId(eId);
        error.setStatus("ready");
        error.setaId(aId);
        errorService.updateError(error);
        // 3. 管理员完成任务
        taskService.complete(task.getId());

        return RespBean.ok("手动分配成功");
    }

    /**
     * 韩 宁
     * 维修人员接受任务
     * 根据eId也就是businessKey找到流程实例，并给该实例添加accept变量,接受后改变error的状态为维修中
     *
     * @param eId
     * @param accept
     * @return
     */
    @GetMapping("/maintain/accept")
    public RespBean acceptTask(Integer eId, Boolean accept) {
        Task task = taskService.createTaskQuery()
                .processInstanceBusinessKey(String.valueOf(eId))
                .singleResult();
        // 并给该实例添加accept变量
        taskService.setVariable(task.getId(), "accept", accept);
        // 若接受后改变error的状态为“fixing”,拒绝状态改为“unDistribution”
        if (accept) {
            Error error = new Error();
            error.setId(eId);
            error.setStatus("fixing");
            errorService.updateError(error);
        } else {
            Error error = new Error();
            error.setId(eId);
            error.setStatus("unDistribution");
            errorService.updateError(error);
        }
        // 完成任务
        taskService.complete(task.getId());
        return accept ? RespBean.ok("接受以任务") : RespBean.ok("任务以拒绝");
    }


    //完成任务


    @PostMapping("/finish/")
    public RespBean complete(@RequestBody Receipt receipt) {

        String aId = receipt.getAccountId().toString();
        String eId = receipt.getErrorId().toString();

        Task task = taskService//
                .createTaskQuery()//
                .taskAssignee(aId)
                .processInstanceBusinessKey(eId)
                .taskName("维修")//指定个人任务查询
                .singleResult();

        taskService.complete(task.getId());
        System.out.println("新增回单");
        return rs.RepairComplete(receipt);
    }
}

package edu.bupt.slms.controller.activiti;

import edu.bupt.slms.bean.Error;
import edu.bupt.slms.bean.Receipt;
import edu.bupt.slms.bean.RespBean;
import edu.bupt.slms.service.ErrorService;
import edu.bupt.slms.service.activiti.repair.CreateReceipt;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    private CreateReceipt createReceipt;
    @Autowired
    ErrorService errorService;


    /**
     * 韩宁
     * 接受错误并创建实例
     * @param error 产生的错误信息
     * @param auto  是否是自动分配
     * @return
     */
    @PostMapping("/repair/")
    public RespBean addError(@RequestBody Error error,Boolean auto) {
        // 1. 存错error信息
        error.setStatus("unDistribution");
        if (errorService.addError(error) != 1) {
            return RespBean.error("添加失败！");
        }
        // 2. 启动流程实例
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
    public RespBean manualDistribution(Integer eId,Integer aId) {
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
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    public boolean complete(@RequestParam(value = "aId", required = true) String aId, Receipt receipt) {

        List<Task> list = processEngine.getTaskService()//
                .createTaskQuery()//
                .taskAssignee(aId)
                .processDefinitionKey("repair")//指定个人任务查询
                .list();
        taskService.complete(list.get(0).getId());
        System.out.println("新增回单");
        return createReceipt.RepairComplete(receipt);
    }
}
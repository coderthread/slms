package edu.bupt.slms;

import edu.bupt.slms.service.activiti.repair.Alarm;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SlmsApplicationTests {

    @Autowired
    RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;

    private String processInstanceId;


    @Test
    void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("alarm",new Alarm());
        map.put("auto",true);
        ProcessInstance holiday = runtimeService.startProcessInstanceByKey("repair1","1001",map);
    }

    @Test
    public void testTask() {
        TaskQuery taskQuery = taskService.createTaskQuery();
        System.out.println(processInstanceId);
        List<Task> tasks = taskQuery.taskAssignee("lisi").list();
        for (Task task : tasks) {
            System.out.println(task.getName());
            System.out.println(task.getId());
            taskService.complete(task.getId());
        }
    }
}

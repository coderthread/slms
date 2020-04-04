package edu.bupt.slms;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        ProcessInstance holiday = runtimeService.startProcessInstanceByKey("repair","1001");
        System.out.println(holiday.getProcessDefinitionKey());
        System.out.println(holiday.getId());
        System.out.println(holiday.getBusinessKey());
        System.out.println(holiday.getProcessDefinitionId());
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

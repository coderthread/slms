package edu.bupt.slms.service.activiti;

import org.activiti.engine.runtime.Execution;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author: 韩 宁
 * @create: 2020/04/04 15:40:24
 */

public class ActivitiRepair implements Serializable {

    public void alarm(Execution execution) {
        System.out.println("alarm>>>>>>>>>>>>>"+execution);
    }
}

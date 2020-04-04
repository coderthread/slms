package edu.bupt.slms;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SecurityAutoConfiguration.class 去掉activiti的安全认证，注意：不要导错了包
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan(basePackages = "edu.bupt.slms.mapper")
public class SlmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlmsApplication.class, args);
    }

}

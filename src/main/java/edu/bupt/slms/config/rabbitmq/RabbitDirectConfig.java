package edu.bupt.slms.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 韩 宁
 * @create: 2020/04/18 10:24:01
 */
@Configuration
public class RabbitDirectConfig {
    // 故障报警邮件的消息队列
    @Bean
    Queue errorAlarm() {
        return new Queue("slms.mail.errorAlarm");
    }
}

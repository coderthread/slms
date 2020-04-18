package edu.bupt.slms.mali;

import edu.bupt.slms.bean.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @author: 韩 宁
 * @create: 2020/04/18 11:36:10
 */
@Component
public class ErrorMail {
    public static final Logger logger = LoggerFactory.getLogger(ErrorMail.class);
    @Autowired
    JavaMailSender javaMailSender;
    // 获取mail配置信息
    @Autowired
    MailProperties mailProperties;
    @Autowired
    TemplateEngine templateEngine;

    @RabbitListener(queues = "slms.mail.errorAlarm")
    public void sendAlarm(Error error) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        try {
            helper.setTo("706697727@qq.com");
            helper.setFrom(mailProperties.getUsername());
            helper.setSubject("故障报警");
            helper.setSentDate(new Date());
            Context context = new Context();
            context.setVariable("poleId",error.getPole().getId());
            context.setVariable("polePosition",error.getPole().getPosition());
            context.setVariable("date",error.getDate());
            context.setVariable("type",error.getType());
            context.setVariable("des",error.getDes());
            context.setVariable("importance",error.getImportance());
            String alarmMail = templateEngine.process("alarmMail", context);
            helper.setText(alarmMail,true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}

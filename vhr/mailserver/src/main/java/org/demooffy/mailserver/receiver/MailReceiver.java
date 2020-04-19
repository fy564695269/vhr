package org.demooffy.mailserver.receiver;

import com.example.springbootvhr.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
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
import java.util.HashMap;
import java.util.Map;

@Component
public class MailReceiver {

    public static final Logger logger = LoggerFactory.getLogger(MailReceiver.class);

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    MailProperties mailProperties;
    @Autowired
    TemplateEngine templateEngine;
    @RabbitListener(queues = "fy.mail.welcome")
    public void handler(Employee employee) {
        //收到消息，发送邮件
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);
        logger.info(employee.toString());
        try {
            helper.setTo(employee.getEmail());
            helper.setFrom(mailProperties.getUsername());
            helper.setSubject("入职欢迎邮件");
            helper.setSentDate(new Date());
            Context context = new Context();
            Map map =new HashMap<>();
            map.put("name",employee.getName());
            map.put("posname",employee.getPosition().getName());
            map.put("jname",employee.getJoblevel().getName());
            map.put("dname",employee.getDepartment().getName());
            context.setVariables(map);
            System.out.println(employee);
            String mail = templateEngine.process("mail", context);//渲染mail.html
            helper.setText(mail,true);
            javaMailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("邮件发送失败："+e.getMessage());
        }
    }
    @RabbitListener(queues = "fy.test")
    public void handler1(Employee employee){
        System.out.println("测试成功！员工名为："+employee.getName());
    }
}

package org.demooffy.mailserver;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MailserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailserverApplication.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue("fy.mail.welcome");
    }
    @Bean
    Queue queue1(){
        return new Queue("fy.test");
    }
}

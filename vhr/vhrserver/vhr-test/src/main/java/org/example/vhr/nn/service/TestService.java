package org.example.vhr.nn.service;

import com.example.springbootvhr.entity.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    RabbitTemplate rabbitTemplate;
    public void testRabbit(){
        Employee employee =new Employee();
        employee.setName("fy_hahahah");
        rabbitTemplate.convertAndSend("fy.test",employee);
    }
}

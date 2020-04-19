package com.example.springbootvhr.controller;
import org.example.vhr.nn.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitTestController {
    @Autowired
    TestService testService;
    @GetMapping("/test/rabbit")
    public void RabbitTestController(){
        System.out.println("测试开始....");
        testService.testRabbit();
    }
}

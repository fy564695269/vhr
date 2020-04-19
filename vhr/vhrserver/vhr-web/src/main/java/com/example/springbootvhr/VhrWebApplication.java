package com.example.springbootvhr;

import com.example.springbootvhr.controller.WebSocketController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.springbootvhr", "org.example.vhr"})
@MapperScan(basePackages = "com.example.springbootvhr.dao")
public class VhrWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(VhrWebApplication.class, args);
    }

}

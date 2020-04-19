package com.example.springbootvhr.controller;

import com.example.springbootvhr.entity.ChatMessage;
import com.example.springbootvhr.job.DepartmentSchedule;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

import com.example.springbootvhr.service.system.basic.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSocketController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    DepartmentService departmentService;

    @MessageMapping("/ws/chat")
    public void handleMsg(Principal principal, ChatMessage chatMessage) {
        chatMessage.setFrom(principal.getName());
        chatMessage.setDate(new Date());
        simpMessagingTemplate.convertAndSendToUser(chatMessage.getTo(), "/queue/chat", chatMessage);
    }

    @MessageMapping("/ws/job")
    public void handleJob(Principal principal) throws SchedulerException {
        new DepartmentSchedule().startDepSchedule(departmentService,simpMessagingTemplate,principal.getName());
    }
//    @GetMapping("/ttt/job")
//    public void handleJob(Principal principal) throws SchedulerException {
//        new DepartmentSchedule().startDepSchedule(departmentService, simpMessagingTemplate, principal.getName());
//    }
}

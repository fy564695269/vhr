package com.example.springbootvhr.controller;

import com.example.springbootvhr.entity.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springbootvhr.service.HrService;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    HrService hrService;
    @GetMapping("/hrs")
    public List<Hr> getAllHrs(){
        return hrService.getAllHrs("");
    }
}

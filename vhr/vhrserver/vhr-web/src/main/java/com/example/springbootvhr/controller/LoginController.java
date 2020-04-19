package com.example.springbootvhr.controller;

import com.example.springbootvhr.entity.ResponseBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/login")
    public ResponseBean login() {
        return ResponseBean.error("尚未登录，请登录！");
    }
}

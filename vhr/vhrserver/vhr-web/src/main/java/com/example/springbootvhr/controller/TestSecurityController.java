package com.example.springbootvhr.controller;

import com.example.springbootvhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Hr)表控制层
 *
 * @author makejava
 * @since 2020-02-18 20:29:49
 */
@RestController
public class TestSecurityController {
    /**
     * 服务对象
     */
    @Autowired
    private HrService hrService;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/employee/basic/hello")
    public String hello1() {
        return "/employee/basic/hello";
    }

    @RequestMapping("/employee/advanced/hello")
    public String hello2() {
        return "/employee/advanced/hello";
    }
}
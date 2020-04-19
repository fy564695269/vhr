package com.example.springbootvhr.controller.config;

import com.example.springbootvhr.entity.Menu;
import com.example.springbootvhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/config")
public class SysConfigController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/menu")
    public List<Menu> getMenuById() {
        return menuService.getMenuByHrId();
    }
}

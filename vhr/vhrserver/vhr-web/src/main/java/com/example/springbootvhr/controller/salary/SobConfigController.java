package com.example.springbootvhr.controller.salary;

import com.example.springbootvhr.entity.Employee;
import org.example.vhr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary/sobcfg")
public class SobConfigController {
    @Autowired
    EmployeeService employeeService;
}

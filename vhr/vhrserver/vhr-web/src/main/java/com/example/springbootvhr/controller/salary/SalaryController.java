package com.example.springbootvhr.controller.salary;

import com.example.springbootvhr.entity.ResponseBean;
import com.example.springbootvhr.entity.Salary;
import org.example.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/salary/sob")
@RestController
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }
    @PostMapping("/")
    public ResponseBean addSalary(@RequestBody Salary salary){
        if (salaryService.add(salary)==1){
            return ResponseBean.ok("添加成功");
        }
        return ResponseBean.error("添加失败");
    }
}

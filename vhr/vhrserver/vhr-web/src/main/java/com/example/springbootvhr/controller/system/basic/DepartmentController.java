package com.example.springbootvhr.controller.system.basic;

import com.example.springbootvhr.entity.Department;
import com.example.springbootvhr.entity.ResponseBean;
import com.example.springbootvhr.service.system.basic.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public ResponseBean addDep(@RequestBody Department department) {
        departmentService.addDep(department);
        if (department.getResult() == 1) {
            return ResponseBean.ok("添加成功！", department);
        }
        return ResponseBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteDep(@PathVariable Integer id) {
        Department department = new Department();
        department.setId(id);
        departmentService.deleteDep(department);
        if (department.getResult() == -2) {
            return ResponseBean.error("该部门下有子部门,删除失败");
        } else if (department.getResult() == -1) {
            return ResponseBean.error("该部门下有员工，删除失败");
        } else if (department.getResult() == 1) {
            return ResponseBean.ok("删除成功");
        }
        return ResponseBean.error("删除失败");
    }
}

package com.example.springbootvhr.controller.emp;

import com.example.springbootvhr.entity.*;
import org.example.vhr.service.EmployeeService;
import org.example.vhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public RespPageBean getEmpByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,
                                     Employee employee, Date[] beginDateScope) {
        System.out.println(employee);
        System.out.println(beginDateScope);
        System.out.println(page + "---size=" + size);
        return employeeService.getEmpByPage(page, size, employee, beginDateScope);
    }

    @PostMapping("/")
    public ResponseBean addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return ResponseBean.ok("添加成功");
        }
        return ResponseBean.error("添加失败");
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus() {
        return employeeService.getAllPoliticsstatus();
    }

    @GetMapping("/nation")
    public List<Nation> getAllNations() {
        return employeeService.getAllNations();
    }

    @GetMapping("/position")
    public List<Position> getAllPositions() {
        return employeeService.getAllPositions();
    }

    @GetMapping("/joblevel")
    public List<Joblevel> getAllJobLevels() {
        return employeeService.getAllJobLevels();
    }

    @GetMapping("/maxWorkId")
    public ResponseBean getMaxId() {
        return ResponseBean.build().setStatus(200).setObj(String.format("%08d", employeeService.getMaxId() + 1));
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments() {
        return employeeService.getAllDepartments();
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteEmpById(@PathVariable Integer id) {
        if (employeeService.deleteEmpById(id) == 1) {
            return ResponseBean.ok("删除成功");
        }
        return ResponseBean.error("删除失败");
    }

    @PutMapping("/")
    public ResponseBean updateEmp(@RequestBody Employee employee) {
        if (employeeService.updateEmp(employee) == 1) {
            return ResponseBean.ok("更新成功");
        }
        return ResponseBean.error("更新失败");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        List<Employee> list = (List<Employee>) employeeService.getEmpByPage(null, null, null, null).getData();
        return POIUtils.employeeToExcel(list);
    }

    @PostMapping("/import")
    public ResponseBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excelToEmployee(file, employeeService.getAllNations(),
                employeeService.getAllPoliticsstatus(), employeeService.getDepartmentsWithOutRecursion(),
                employeeService.getAllPositions(), employeeService.getAllJobLevels());
        if (employeeService.addEmpList(list) == list.size()) {
            return ResponseBean.ok("上传成功");
        }
        return ResponseBean.error("上传失败");
    }
}

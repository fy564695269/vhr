package com.example.springbootvhr.service.system.basic;

import com.example.springbootvhr.dao.DepartmentDao;
import com.example.springbootvhr.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartmentsById(-1);
    }

    public void addDep(Department department) {
        department.setEnabled(true);
        departmentDao.addDep(department);
    }

    public void deleteDep(Department department) {
        departmentDao.deleteDep(department);
    }

    public List<Department> queryIdAndName(){
        return departmentDao.queryAllDeps();
    }

    public Department queryById( int id ){
        return departmentDao.queryById(id);
    }
    //不允许用的
    public void updateDepParentIdById(int id){
        departmentDao.updateDepParentIdById(id);
    }
}

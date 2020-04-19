package org.example.vhr.service;

import com.example.springbootvhr.dao.SalaryDao;
import com.example.springbootvhr.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {
    @Autowired
    SalaryDao salaryDao;

    public List<Salary> getAllSalaries() {
        return salaryDao.getAllSalaries();
    }

    public int add(Salary salary) {
        return salaryDao.insert(salary);
    }
}

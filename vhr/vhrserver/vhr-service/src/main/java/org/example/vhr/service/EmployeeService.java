package org.example.vhr.service;

import com.example.springbootvhr.dao.*;
import com.example.springbootvhr.entity.*;
import com.example.springbootvhr.service.system.basic.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    PoliticsstatusDao politicsstatusDao;
    @Autowired
    NationDao nationDao;
    @Autowired
    PositionDao positionDao;
    @Autowired
    JoblevelDao joblevelDao;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    RabbitTemplate rabbitTemplate;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    //分页处理
    public RespPageBean getEmpByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeDao.getEmpByPage(page, size, employee, beginDateScope);
        Long total = employeeDao.getTotal(employee, beginDateScope);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(data);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    public int addEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 +
                Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        int result = employeeDao.insert(employee);
        if (result == 1) {
            Employee emp = employeeDao.queryEmpById(employee.getId());
            logger.info(emp.toString());
            rabbitTemplate.convertAndSend("fy.mail.welcome", emp);//发送到fy.mail.welcome队列
        }
        return result;
    }

    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusDao.getAllPoliticsstatus();
    }

    public List<Nation> getAllNations() {
        return nationDao.getAllNations();
    }

    public List<Position> getAllPositions() {
        return positionDao.getAllPositions();
    }

    public List<Joblevel> getAllJobLevels() {
        return joblevelDao.getAllJobLevel();
    }

    public Integer getMaxId() {
        return employeeDao.getMaxId();
    }

    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    public int deleteEmpById(Integer id) {
        return employeeDao.deleteById(id);
    }

    public int updateEmp(Employee employee) {
        return employeeDao.update(employee);
    }

    public List<Department> getDepartmentsWithOutRecursion() {
        return departmentDao.queryAllDeps();
    }

    public int addEmpList(List<Employee> list) {
        return employeeDao.addEmpList(list);
    }
}

package com.example.springbootvhr.job;

import com.example.springbootvhr.dao.DepartmentDao;
import com.example.springbootvhr.entity.Department;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import com.example.springbootvhr.service.system.basic.DepartmentService;

import java.security.Principal;
import java.util.List;

public class DepartmentJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap map = jobExecutionContext.getJobDetail().getJobDataMap();
        DepartmentService departmentService = (DepartmentService) map.get("departmentService");
        SimpMessagingTemplate simpMessagingTemplate = (SimpMessagingTemplate) map.get("simpMessagingTemplate");
        String name = (String) map.get("name");
        Department department = departmentService.queryById(106);
        System.out.println(department);
        simpMessagingTemplate.convertAndSendToUser(name, "/queue/job", department.getParentId());
        departmentService.updateDepParentIdById(106);
    }
}

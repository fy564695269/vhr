package com.example.springbootvhr.job;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import com.example.springbootvhr.service.system.basic.DepartmentService;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.security.Principal;


public class DepartmentSchedule {
    public void startDepSchedule(DepartmentService departmentService, SimpMessagingTemplate simpMessagingTemplate, String name) throws SchedulerException {
        JobDataMap map =new JobDataMap();
        map.put("departmentService",departmentService);
        map.put("simpMessagingTemplate",simpMessagingTemplate);
        map.put("name",name);
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(DepartmentJob.class).withIdentity("departmentJob")
                .usingJobData(map)
                .build();
        Trigger trigger = TriggerBuilder.newTrigger().startNow().withIdentity("depTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}

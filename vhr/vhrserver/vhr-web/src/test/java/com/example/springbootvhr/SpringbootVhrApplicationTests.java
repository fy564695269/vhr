package com.example.springbootvhr;

import com.example.springbootvhr.job.DepartmentSchedule;
import com.example.springbootvhr.service.system.basic.PositionService;
import org.junit.jupiter.api.Test;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringbootVhrApplicationTests {
    @Autowired
    PositionService positionService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    com.example.springbootvhr.service.system.basic.DepartmentService departmentService;
    @Test
    void contextLoads() {

    }

    public List test() {
        List list = new ArrayList();
        List list1 = new ArrayList();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        List list2 = new ArrayList();
        list1.stream().forEach(li -> {
            if (li == "bb") {
                for (int i = 0; i < list.size(); i++) {
                    Integer j = (Integer) list.get(i);
                    list2.add(j * j);
                }
            }
        });
        return list2;
    }
}

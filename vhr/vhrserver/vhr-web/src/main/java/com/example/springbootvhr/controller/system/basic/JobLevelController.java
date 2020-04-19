package com.example.springbootvhr.controller.system.basic;

import com.example.springbootvhr.entity.Joblevel;
import com.example.springbootvhr.entity.ResponseBean;
import com.example.springbootvhr.service.system.basic.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<Joblevel> getAllJobLevel() {
        return jobLevelService.getAllJobLevel();
    }

    @PostMapping("/")
    public ResponseBean addJobLevel(@RequestBody Joblevel joblevel) {
        if (jobLevelService.addJobLevel(joblevel) == 1) {
            return ResponseBean.ok("添加成功！");
        } else
            return ResponseBean.error("添加失败！");
    }

    @PutMapping("/")
    public ResponseBean updateJobLevel(@RequestBody Joblevel joblevel) {
        if (jobLevelService.updateJobLevel(joblevel) == 1) {
            return ResponseBean.ok("修改成功！");
        } else
            return ResponseBean.error("修改失败！");
    }

    @DeleteMapping("/{id}")
    public ResponseBean deleteJobLevel(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevel(id) == 1) {
            return ResponseBean.ok("删除成功！");
        } else
            return ResponseBean.error("删除失败！");
    }

    @DeleteMapping("/")
    public ResponseBean deleteJobLevels(Integer[] ids) {
        if (jobLevelService.deleteJobLevels(ids) == ids.length) {
            return ResponseBean.ok("删除成功！");
        } else
            return ResponseBean.error("删除失败！");
    }
}

package com.example.springbootvhr.service.system.basic;

import com.example.springbootvhr.dao.JoblevelDao;
import com.example.springbootvhr.entity.Joblevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobLevelService {
    @Autowired
    JoblevelDao joblevelDao;

    public List<Joblevel> getAllJobLevel() {
        return joblevelDao.getAllJobLevel();
    }

    public Integer addJobLevel(Joblevel joblevel) {
        joblevel.setEnabled(true);
        joblevel.setCreateDate(new Date());
        return joblevelDao.insert(joblevel);
    }

    public Integer updateJobLevel(Joblevel joblevel) {
        return joblevelDao.update(joblevel);
    }

    public Integer deleteJobLevel(Integer id) {
        return joblevelDao.deleteById(id);
    }

    public Integer deleteJobLevels(Integer[] ids) {
        return joblevelDao.deleteJobLevels(ids);
    }
}

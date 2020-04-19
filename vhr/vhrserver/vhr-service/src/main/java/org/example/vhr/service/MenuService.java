package com.example.springbootvhr.service;

import com.example.springbootvhr.dao.MenuDao;
import com.example.springbootvhr.dao.MenuRoleDao;
import com.example.springbootvhr.entity.Hr;
import com.example.springbootvhr.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuDao menuDao;
    @Autowired
    MenuRoleDao menuRoleDao;

    public List<Menu> getMenuByHrId() {
        return menuDao.getMenuByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());//从security拿登录用户信息
    }

    //    @Cacheable
    public List<Menu> getAllMenusWithRole() {
        return menuDao.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return menuDao.getAllMenus();
    }

    public List<Integer> getMdisByRid(Integer rid) {
        return menuDao.getMdisByRid(rid);
    }

    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleDao.deleteByRid(rid);
        if (mids != null && mids.length != 0) {
            Integer result = menuRoleDao.insertRecords(rid, mids);
            return result == mids.length;
        }
        return true;
    }
}

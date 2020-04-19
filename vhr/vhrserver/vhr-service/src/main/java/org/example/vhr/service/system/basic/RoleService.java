package com.example.springbootvhr.service.system.basic;

import com.example.springbootvhr.dao.RoleDao;
import com.example.springbootvhr.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public int addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return roleDao.insert(role);
    }

    public int deleteRoleById(Integer rid) {
        return roleDao.deleteRoleById(rid);
    }

    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}

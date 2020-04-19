package com.example.springbootvhr.controller.system.basic;

import com.example.springbootvhr.dao.RoleDao;
import com.example.springbootvhr.entity.Menu;
import com.example.springbootvhr.entity.ResponseBean;
import com.example.springbootvhr.entity.Role;
import com.example.springbootvhr.service.MenuService;
import com.example.springbootvhr.service.system.basic.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    RoleDao roleDao;
    @Autowired
    MenuService menuService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMdisByRid(@PathVariable Integer rid) {
        return menuService.getMdisByRid(rid);
    }

    @PutMapping("/")
    public ResponseBean updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return ResponseBean.ok("更新成功!");
        }
        return ResponseBean.error("更新失败！");
    }

    @PostMapping("/role")
    public ResponseBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return ResponseBean.ok("添加成功!");
        }
        return ResponseBean.error("添加失败!");
    }

    @DeleteMapping("/{rid}")
    public ResponseBean deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }
}

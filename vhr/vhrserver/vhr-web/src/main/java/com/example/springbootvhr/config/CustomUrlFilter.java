package com.example.springbootvhr.config;

import com.example.springbootvhr.entity.Menu;
import com.example.springbootvhr.entity.Role;
import com.example.springbootvhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomUrlFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override  //返回符合当前请求的角色
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl(); //拿到当前路径
        List<Menu> menus = menuService.getAllMenusWithRole();
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

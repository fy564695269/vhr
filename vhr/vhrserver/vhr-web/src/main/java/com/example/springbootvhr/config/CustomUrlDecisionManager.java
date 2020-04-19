package com.example.springbootvhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        //authentication存储当前登录用户信息，o是当前的请求
        for (ConfigAttribute configAtr : collection) {
            String needRole = configAtr.getAttribute(); //当前路径所需要的角色,一次拿一个
            if ("ROLE_LOGIN".equals(needRole)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    //AnonymousAuthenticationToken是匿名用户,也就是没登录
                    throw new AccessDeniedException("尚未登录，请登录!");
                } else {
                    return;//都可以访问的资源
                }
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();//当前登录用户拥有的角色
            for (GrantedAuthority ga : authorities) {
                if (ga.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

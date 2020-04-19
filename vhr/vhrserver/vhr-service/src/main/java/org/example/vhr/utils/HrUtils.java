package org.example.vhr.utils;

import com.example.springbootvhr.entity.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

public class HrUtils {
    //获取当前登录对象
    public static Hr getCurrentHr() {
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

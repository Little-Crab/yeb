package com.pjf.server.util;

import com.pjf.server.entity.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author pjf
 * 类名：AdminUtils
 * 创建时间: 2021/12/28 15:52.
 */
public class AdminUtils {
    private AdminUtils() {
    }

    /**
     * 获取当前登录操作员
     *
     * @return 返回操作员
     */
    public static Admin getCurrentAdmin() {
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

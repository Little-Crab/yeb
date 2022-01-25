package com.pjf.server.service;

import com.pjf.server.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 根据用户Id查询菜单列表
     * @return 返回菜单列表
     */
    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     * @return 返回菜单列表
     */
    List<Menu> getMenusWithRole();

    /**
     * 获取所有菜单
     * @return 返回菜单列表
     */
    List<Menu> getAllMenus();
}

package com.pjf.server.mapper;

import com.pjf.server.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 根据用户Id查询菜单列表
     *
     * @param id 用户Id
     * @return 菜单列表
     */
    List<Menu> getMenusByAdminId(Integer id);

    /**
     * 根据角色获取菜单列表
     * @return 返回菜单列表
     */
    List<Menu> getMenusWithRole();

    /**
     * 获取所有菜单
     * @return 菜单列表
     */
    List<Menu> getAllMenus();
}

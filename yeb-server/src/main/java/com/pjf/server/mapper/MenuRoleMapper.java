package com.pjf.server.mapper;

import com.pjf.server.entity.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 更新角色菜单
     *
     * @param mids 菜单id
     * @return 更新条数
     */
    Integer insertReport(Integer[] mids,Integer rid);
}

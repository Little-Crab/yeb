package com.pjf.server.service;

import com.pjf.server.entity.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pjf.server.util.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid 角色id
     * @param mids 菜单ids
     * @return 返回
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}

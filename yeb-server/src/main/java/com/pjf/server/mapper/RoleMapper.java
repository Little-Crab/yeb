package com.pjf.server.mapper;

import com.pjf.server.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户id去获取用户角色
     *
     * @param adminId 用户id
     * @return 角色
     */
    List<Role> getRoles(Integer adminId);
}

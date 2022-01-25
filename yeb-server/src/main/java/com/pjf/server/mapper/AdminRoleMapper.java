package com.pjf.server.mapper;

import com.pjf.server.entity.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pjf.server.util.RespBean;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    /**
     * 更新操作员角色
     *
     * @param adminId 操作员id
     * @param rids    角色id
     * @return 返回
     */
    Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}

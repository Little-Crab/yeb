package com.pjf.server.mapper;

import com.pjf.server.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pjf.server.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 获取所有操作员
     * @param keywords 获取
     * @return 返回操作员
     */
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}

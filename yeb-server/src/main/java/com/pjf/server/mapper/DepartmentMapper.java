package com.pjf.server.mapper;

import com.pjf.server.entity.Department;
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
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 获取所有部门
     *
     * @param parentId 父id
     * @return 部门列表
     */
    List<Department> getAllDepartments(Integer parentId);

    /**
     * 添加不买呢
     * @param department 部门
     * @return 返回添加结果
     */
    void addDep(Department department);

    /**
     * 删除部门
     * @param department 部门id
     */
    void deleteDep(Department department);
}

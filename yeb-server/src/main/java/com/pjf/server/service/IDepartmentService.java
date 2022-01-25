package com.pjf.server.service;

import com.pjf.server.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pjf.server.util.RespBean;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 获取所有部门
     *
     * @param parentId 父id
     * @return 部门列表
     */
    List<Department> getAllDepartments(Integer parentId);

    /**
     * 添加部门
     *
     * @param department 部门信息
     * @return 返回添加结果
     */
    RespBean addDep(Department department);

    /**
     * 删除部门
     *
     * @param id 部门id
     * @return 返回删除结果
     */
    RespBean deleteDep(Integer id);

}

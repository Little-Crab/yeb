package com.pjf.server.service.impl;

import com.pjf.server.entity.Department;
import com.pjf.server.mapper.DepartmentMapper;
import com.pjf.server.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pjf.server.util.RespBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDepartments(Integer parentId) {
        return departmentMapper.getAllDepartments(parentId);
    }

    @Override
    public RespBean addDep(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
        if (1 == department.getResult()) {
            return RespBean.success("添加成功", department);
        }
        return RespBean.error("添加失败");
    }

    @Override
    public RespBean deleteDep(Integer id) {
        Department department = new Department();
        department.setId(id);
        departmentMapper.deleteDep(department);
        if (-2 == department.getResult()) {
            return RespBean.error("该部门下还有子部门！删除失败");
        } else if (-1 == department.getResult()) {
            return RespBean.error("该部门下还有员工！删除失败");
        }
        if (1 == department.getResult()) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}

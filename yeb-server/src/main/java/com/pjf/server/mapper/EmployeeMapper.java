package com.pjf.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjf.server.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 分页查询
     *
     * @param page           page
     * @param employee       employee
     * @param beginDateScope scope
     * @return 返回结果
     */
    IPage<Employee> getEmployeeByPage(Page<Employee> page, @Param("employee") Employee employee, @Param("beginDateScope") LocalDate[] beginDateScope);


    /**
     * 查询员工
     *
     * @param id 员工id
     * @return 返回员工列表
     */
    List<Employee> getEmployee(Integer id);
    /**
     * 获取所有员工工资账套
     * @param page 分页
     * @return 返回数据
     */
    IPage<Employee> getEmployeeWithSalary(Page<Employee> page);
}

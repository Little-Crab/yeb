package com.pjf.server.service;

import com.pjf.server.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pjf.server.entity.RespPageBean;
import com.pjf.server.util.RespBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 获取所有员工（分页）
     *
     * @param currentPage    页数
     * @param size           一页大小
     * @param employee       条件
     * @param beginDateScope 时间
     * @return 返回数据
     */
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    /**
     * 获取最大工号
     *
     * @return 返回最大工号
     */
    RespBean maxWorkID();

    /**
     * 添加员工
     *
     * @param employee 员工信息
     * @return 返回添加结果
     */
    RespBean addEmp(Employee employee);

    /**
     * 查询员工
     *
     * @param id 员工id
     * @return 返回员工列表
     */
    List<Employee> getEmployee(Integer id);

    /**
     * 获取所有员工工资账套
     * @param currentPage 页数
     * @param size 一页大小
     * @return 返回数据
     */
    RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size);
}

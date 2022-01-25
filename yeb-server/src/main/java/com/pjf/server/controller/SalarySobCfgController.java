package com.pjf.server.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.pjf.server.entity.Employee;
import com.pjf.server.entity.RespPageBean;
import com.pjf.server.entity.Salary;
import com.pjf.server.service.IEmployeeService;
import com.pjf.server.service.ISalaryService;
import com.pjf.server.util.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pjf
 * @Date 2022/1/13 13:35
 * 员工账套
 **/
@RestController
@Api(tags = "员工账套管理")
@RequestMapping("/salary/sobcfg")
public class SalarySobCfgController {

    @Resource
    private ISalaryService salaryService;
    @Resource
    private IEmployeeService employeeService;

    @ApiOperation("获取所有工资账套")
    @GetMapping("/salaries")
    public List<Salary> getAllSalaries() {
        return salaryService.list();
    }

    @ApiOperation("获取所有员工账套")
    @GetMapping("/")
    public RespPageBean getEmployeeWithSalary(@RequestParam(defaultValue = "1") Integer currentPage,
                                              @RequestParam(defaultValue = "10") Integer size) {
        return employeeService.getEmployeeWithSalary(currentPage, size);
    }

    @ApiOperation("更新员工账套")
    @PutMapping("/")
    public RespBean updateEmployeeSalary(Integer eid, Integer sid) {
        if (employeeService.update(new UpdateWrapper<Employee>().set("salaryId", sid).eq("id", eid))) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }
}

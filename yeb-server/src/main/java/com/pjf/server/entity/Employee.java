package com.pjf.server.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
@Data
@ToString
@TableName("t_employee")
@ApiModel(value = "Employee对象")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工编号", example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("员工姓名")
    @Excel(name = "员工姓名")
    private String name;

    @ApiModelProperty("性别")
    @Excel(name = "性别")
    private String gender;

    @ApiModelProperty("出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @Excel(name = "出生日期", width = 20, format = "yyyy-MM-dd")
    private LocalDate birthday;

    @ApiModelProperty("身份证号")
    @Excel(name = "身份证号", width = 20)
    private String idCard;

    @ApiModelProperty("婚姻状况")
    @Excel(name = "婚姻状况")
    private String wedlock;

    @ApiModelProperty(value = "民族", example = "1")
    private Integer nationId;

    @ApiModelProperty("籍贯")
    @Excel(name = "籍贯")
    private String nativePlace;

    @ApiModelProperty(value = "政治面貌", example = "1")
    private Integer politicId;

    @ApiModelProperty("邮箱")
    @Excel(name = "邮箱", width = 20)
    private String email;

    @ApiModelProperty("电话号码")
    @Excel(name = "电话号码", width = 13)
    private String phone;

    @ApiModelProperty("联系地址")
    @Excel(name = "联系地址", width = 40)
    private String address;

    @ApiModelProperty(value = "所属部门", example = "1")
    private Integer departmentId;

    @ApiModelProperty(value = "职称ID", example = "1")
    private Integer jobLevelId;

    @ApiModelProperty(value = "职位ID", example = "1")
    private Integer posId;

    @ApiModelProperty("聘用形式")
    @Excel(name = "聘用形式")
    private String engageForm;

    @ApiModelProperty("最高学历")
    @Excel(name = "最高学历")
    private String tiptopDegree;

    @ApiModelProperty("所属专业")
    @Excel(name = "所属专业", width = 20)
    private String specialty;

    @ApiModelProperty("毕业院校")
    @Excel(name = "毕业院校", width = 20)
    private String school;

    @ApiModelProperty("入职日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @Excel(name = "入职日期", width = 20, format = "yyyy-MM-dd")
    private LocalDate beginDate;

    @ApiModelProperty("在职状态")
    @Excel(name = "在职状态")
    private String workState;

    @ApiModelProperty("工号")
    @Excel(name = "工号")
    private String workID;

    @ApiModelProperty("合同期限")
    @Excel(name = "合同期限", suffix = "年")
    private Double contractTerm;

    @ApiModelProperty("转正日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @Excel(name = "转正日期", width = 20, format = "yyyy-MM-dd")
    private LocalDate conversionTime;

    @ApiModelProperty("离职日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @Excel(name = "离职日期", width = 20, format = "yyyy-MM-dd")
    private LocalDate notWorkDate;

    @ApiModelProperty("合同起始日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @Excel(name = "合同起始日期", width = 20, format = "yyyy-MM-dd")
    private LocalDate beginContract;

    @ApiModelProperty("合同终止日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @Excel(name = "合同终止日期", width = 20, format = "yyyy-MM-dd")
    private LocalDate endContract;

    @ApiModelProperty(value = "工龄", example = "1")
    @Excel(name = "工龄")
    private Integer workAge;

    @ApiModelProperty(value = "工资账套ID", example = "1")
    private Integer salaryId;

    @ApiModelProperty("民族")
    @TableField(exist = false)
    @ExcelEntity(name = "民族")
    private Nation nation;

    @ApiModelProperty("政治面貌")
    @TableField(exist = false)
    @ExcelEntity(name = "政治面貌")
    private PoliticsStatus politicsStatus;

    @ApiModelProperty("部门")
    @ExcelEntity(name = "部门")
    @TableField(exist = false)
    private Department department;

    @ApiModelProperty("职称")
    @TableField(exist = false)
    @ExcelEntity(name = "职称")
    private Joblevel joblevel;

    @ApiModelProperty("职位")
    @TableField(exist = false)
    @ExcelEntity(name = "职位")
    private Position position;

    @ApiModelProperty("工资账套")
    @TableField(exist = false)
    private Salary salary;
}

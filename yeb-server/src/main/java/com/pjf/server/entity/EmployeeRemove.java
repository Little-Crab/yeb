package com.pjf.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
@TableName("t_employee_remove")
@ApiModel(value = "EmployeeRemove对象", description = "")
public class EmployeeRemove implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id",example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工id",example = "1")
    private Integer eid;

    @ApiModelProperty(value = "调动后部门",example = "1")
    private Integer afterDepId;

    @ApiModelProperty(value = "调动后职位",example = "1")
    private Integer afterJobId;

    @ApiModelProperty("调动日期")
    private LocalDate removeDate;

    @ApiModelProperty("调动原因")
    private String reason;

    @ApiModelProperty("备注")
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
    public Integer getAfterDepId() {
        return afterDepId;
    }

    public void setAfterDepId(Integer afterDepId) {
        this.afterDepId = afterDepId;
    }
    public Integer getAfterJobId() {
        return afterJobId;
    }

    public void setAfterJobId(Integer afterJobId) {
        this.afterJobId = afterJobId;
    }
    public LocalDate getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(LocalDate removeDate) {
        this.removeDate = removeDate;
    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "EmployeeRemove{" +
            "id=" + id +
            ", eid=" + eid +
            ", afterDepId=" + afterDepId +
            ", afterJobId=" + afterJobId +
            ", removeDate=" + removeDate +
            ", reason=" + reason +
            ", remark=" + remark +
        "}";
    }
}

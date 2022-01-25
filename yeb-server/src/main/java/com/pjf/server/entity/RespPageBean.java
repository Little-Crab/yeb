package com.pjf.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author pjf
 * 类名：RespPageBean 分页公共返回对象
 * 创建时间: 2022/1/5 10:05.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespPageBean {
    /**
     * 总条数
     */
    private Long total;
    /**
     * 数据集合
     */
    private List<?> data;
}

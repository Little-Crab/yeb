package com.pjf.server.exception;

import com.pjf.server.util.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author pjf
 * 类名：GlobalException 全局异常处理
 * 创建时间: 2021/12/22 11:31.
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler({SQLException.class})
    public RespBean mySqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return RespBean.error("该数据有关联数据，操作失败");
        }
        return RespBean.error("数据库异常，操作失败");
    }

    @ExceptionHandler({NumberFormatException.class})
    public RespBean exception() {
        return RespBean.error("错误");
    }
}

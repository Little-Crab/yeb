package com.pjf.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pjf.server.entity.Admin;
import com.pjf.server.entity.Role;
import com.pjf.server.util.RespBean;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登录方法
     *
     * @param username 用户名
     * @param password 密码
     * @param code     验证码
     * @param request  request
     * @return 返回
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    Admin getAdminByUserName(String username);

    /**
     * 根据用户id去获取用户角色
     *
     * @param adminId 用户id
     * @return 角色
     */
    List<Role> getRoles(Integer adminId);

    /**
     * 获取所有操作员
     *
     * @param keywords 获取
     * @return 返回操作员
     */
    List<Admin> getAllAdmins(String keywords);

    /**
     * 更新操作员角色
     *
     * @param adminId 操作员id
     * @param rids    角色id
     * @return 返回
     */
    RespBean updateAdminRole(Integer adminId, Integer[] rids);

    /**
     * 修改密码
     *
     * @param oldPass 老密码
     * @param pass    新密码
     * @param adminId 用户id
     * @return 返回修改结果
     */
    RespBean updateAdminPassword(String oldPass, String pass, Integer adminId);

    /**
     * 更新用户头像
     *
     * @param url            图片地址
     * @param id             用户id
     * @param authentication 权限
     * @return 返回更新结果
     */
    RespBean updateAdminUserFace(String url, Integer id, Authentication authentication);
}

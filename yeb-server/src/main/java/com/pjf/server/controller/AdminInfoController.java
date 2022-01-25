package com.pjf.server.controller;

import com.pjf.server.entity.Admin;
import com.pjf.server.service.IAdminService;
import com.pjf.server.util.FastDFSUtils;
import com.pjf.server.util.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author pjf
 * @Date 2022/1/13 16:32
 * 个人中心
 **/
@RestController
@Api(tags = "个人中心")
public class AdminInfoController {
    @Resource
    private IAdminService adminService;

    @ApiOperation("更新当前用户信息")
    @PutMapping("/admin/info")
    public RespBean updateAdmin(@RequestBody Admin admin, Authentication authentication) {
        if (adminService.updateById(admin)) {
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(admin, null, authentication.getAuthorities()));
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation("更新用户密码")
    @PutMapping("/admin/pass")
    public RespBean updateAdminPassword(@RequestBody Map<String, Object> info) {
        String oldPass = (String) info.get("oldPass");
        System.out.println(oldPass);
        String pass = (String) info.get("pass");
        System.out.println(pass);
        Integer adminId = (Integer) info.get("adminId");
        System.out.println(adminId);
        return adminService.updateAdminPassword(oldPass, pass, adminId);
    }

    @ApiOperation("更新用户头像")
    @PostMapping("/admin/userface")
    public RespBean updateAdminUserFace(@RequestPart("file") MultipartFile file, Integer id, Authentication authentication) {
        String[] flePath = FastDFSUtils.upload(file);
        String url = FastDFSUtils.getTrackerUrl() + flePath[0] + "/" + flePath[1];
        return adminService.updateAdminUserFace(url, id, authentication);
    }
}

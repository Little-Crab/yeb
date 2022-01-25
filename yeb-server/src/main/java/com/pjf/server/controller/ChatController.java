package com.pjf.server.controller;

import com.pjf.server.entity.Admin;
import com.pjf.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pjf
 * @Date 2022/1/13 15:38
 * 聊天
 **/
@RestController
@Api(tags = "在线聊天")
@RequestMapping("/chat")
public class ChatController {
    @Resource
    private IAdminService adminService;

    @ApiOperation("获取所有操作员")
    @GetMapping("/admin")
    public List<Admin> getAllAdmins(String keywords) {
        return adminService.getAllAdmins(keywords);
    }
}

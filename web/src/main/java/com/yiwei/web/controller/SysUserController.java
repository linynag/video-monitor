package com.yiwei.web.controller;

import com.yiwei.common.ResponseResult;
import com.yiwei.web.domain.login.LoginRequest;
import com.yiwei.web.entity.SysUser;
import com.yiwei.web.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Autowired
    private SysUserService userService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }


    @GetMapping("/logout")
    public ResponseResult logout() {
        return userService.logout();
    }




    @PostMapping("/list")
    public String list() {
        return "用户管理中心:查看";

    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('userMgr:add')")
    public String add() {
        return "用户管理中心:新增";
    }




}

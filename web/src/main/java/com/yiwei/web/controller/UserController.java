package com.yiwei.web.controller;

import com.yiwei.common.ResponseResult;
import com.yiwei.web.domain.login.LoginRequest;
import com.yiwei.web.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/user")
public class UserController {
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
    @PreAuthorize("hasAuthority('userMgr:list')")
    public String list() {
        return "userMgr:list";

    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('userMgr:add')")
    public String add() {
        return "userMgr:add";
    }


}

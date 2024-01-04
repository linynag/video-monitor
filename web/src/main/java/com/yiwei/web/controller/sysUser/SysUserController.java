package com.yiwei.web.controller.sysUser;

import com.yiwei.common.ResponseResult;
import com.yiwei.web.domain.sysUser.SysUser;
import com.yiwei.web.service.sysUser.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/user")
@PreAuthorize("hasAuthority('userMgr:list')")
public class SysUserController {
    @Autowired
    private SysUserService userService;

    @RequestMapping("/login")
    @PostMapping
    public ResponseResult login(@RequestBody SysUser user) {
        return userService.login(user);
    }


    @RequestMapping("/logout")
    public ResponseResult logout() {
        return userService.logout();
    }


    @RequestMapping("/list")
    public String list() {
        return "用户管理中心:查看";

    }

    @RequestMapping("/add")
    @PreAuthorize("hasAuthority('userMgr:add')")
    public String add() {
        return "用户管理中心:新增";
    }

    // @GetMapping("/list")
    // public void listUserByPage() {
    // }
}

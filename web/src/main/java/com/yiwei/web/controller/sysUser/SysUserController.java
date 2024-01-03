package com.yiwei.web.controller.sysUser;

import com.yiwei.common.ResponseResult;
import com.yiwei.web.domain.sysUser.SysUser;
import com.yiwei.web.service.sysUser.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Autowired
    private SysUserService userService;

    @RequestMapping("/login")
    @PostMapping
    public ResponseResult login(@RequestBody SysUser user) {
        return userService.login(user);
    }


    @RequestMapping("/logout")
    public ResponseResult logout(){
        return userService.logout();
    }

    @RequestMapping("/hello")
    public String hello() {
        return "用户管理中心";
    }




    @GetMapping("/list")
    public void listUserByPage() {
    }
}

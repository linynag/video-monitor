package com.yiwei.web.controller.sysUser;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/sysUser")
public class SysUserController {


    @RequestMapping("/hello")
    public String hello(){
        return "用户管理中心";
    }

    @GetMapping("/list")
    public void listUserByPage() {

    }
}

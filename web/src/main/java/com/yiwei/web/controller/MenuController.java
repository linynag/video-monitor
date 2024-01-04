package com.yiwei.web.controller;

import com.yiwei.web.mapper.SysMenuMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/menu")
@Api(tags = "菜单管理")
public class MenuController {

    @Autowired
    private SysMenuMapper menuMapper;

    @GetMapping("/list/page")
    @ApiOperation("查询菜单")
    public String listMenuByPage() {
        menuMapper.selectList(null);
        return "菜单管理中心:查看";
    }
}

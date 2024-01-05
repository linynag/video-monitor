package com.yiwei.web.controller;


import com.yiwei.web.domain.SysMenuVO;
import com.yiwei.web.entity.SysMenu;
import com.yiwei.web.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/menu")
@Api(tags = "系统配置中心-菜单管理")
public class MenuController {

    @Autowired
    private SysMenuService menuService;

    @PostMapping("/add")
    @ApiOperation("添加菜单")
    public void addMenu(@RequestBody SysMenu menu) {
        menuService.addMenu(menu);
    }


    @GetMapping("/list/page")
    @ApiOperation("查询菜单")
    public List<SysMenuVO> getMenuTree() {
        List<SysMenuVO> menuTree = menuService.getMenuTree();
        return menuTree;
    }


}

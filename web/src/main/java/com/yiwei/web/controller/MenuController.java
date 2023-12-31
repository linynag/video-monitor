package com.yiwei.web.controller;


import com.yiwei.web.domain.sysMenu.MenuAddRequest;
import com.yiwei.web.domain.sysMenu.MenuVO;
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
    public int addMenu(@RequestBody MenuAddRequest menuAddRequest) {
        menuService.addMenu(menuAddRequest);
        return 1;
    }


    @GetMapping("/getMenuTree")
    @ApiOperation("查询菜单列表")
    public List<MenuVO> getMenuTree() {
        List<MenuVO> menuTree = menuService.getMenuTree();
        return menuTree;
    }

    @GetMapping("/getMenuTree/{id}")
    @ApiOperation("查询菜单-通过userId")
    public List<MenuVO> queryMenuTreeByUserId(@PathVariable Long id) {
        List<MenuVO> menuTree = menuService.queryMenuTreeByUserId(id);
        return menuTree;
    }

    @GetMapping("/getMenuTree/current")
    @ApiOperation("查询菜单-当前用户")
    public List<MenuVO> queryCurrentMenuTree() {
        List<MenuVO> menuTree = menuService.queryCurrentMenuTree();
        return menuTree;
    }


}

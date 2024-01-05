package com.yiwei.web.service;

import com.yiwei.web.domain.sysMenu.MenuAddRequest;
import com.yiwei.web.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yiwei.web.domain.sysMenu.MenuVO;

import java.util.List;

/**
* @author EDY
* @description 针对表【sys_menu(菜单功能表)】的数据库操作Service
* @createDate 2024-01-03 17:01:48
*/
public interface SysMenuService extends IService<SysMenu> {

    List<MenuVO> getMenuTree();

    void addMenu(MenuAddRequest menuAddRequest);
}

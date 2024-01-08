package com.yiwei.web.mapper;

import com.yiwei.web.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author EDY
* @description 针对表【sys_menu(菜单功能表)】的数据库操作Mapper
* @createDate 2024-01-03 17:01:48
* @Entity com.yiwei.generator.domain.SysMenu
*/
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    //由于是多表联查，mybatisplus的BaseMapper接口没有提供，我们需要自定义方法，所以需要创建对应的mapper文件，定义对应的sql语句
    List<String> selectPermsByUserId(Long id);

}





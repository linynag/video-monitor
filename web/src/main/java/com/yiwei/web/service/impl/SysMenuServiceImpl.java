package com.yiwei.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yiwei.web.domain.LoginUser;
import com.yiwei.web.domain.sysMenu.MenuAddRequest;
import com.yiwei.web.domain.sysMenu.MenuVO;
import com.yiwei.web.entity.SysMenu;
import com.yiwei.web.entity.SysUser;
import com.yiwei.web.mapper.SysMenuMapper;
import com.yiwei.web.service.SysMenuService;
import com.yiwei.web.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EDY
 * @description 针对表【sys_menu(菜单功能表)】的数据库操作Service实现
 * @createDate 2024-01-03 17:01:48
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
        implements SysMenuService {

    @Autowired
    private SysUserService userService;

    @Override
    public List<MenuVO> getMenuTree() {
        Wrapper queryObj = new QueryWrapper<>().orderByAsc("level", "sort");
        List<SysMenu> allMenu = super.list(queryObj);
        // 0L：表示根节点的父ID
        List<MenuVO> resultList = transferMenuVo(allMenu, 0L);
        return resultList;
    }

    @Override
    public void addMenu(MenuAddRequest menuAddRequest) {
        //  对象转换
        SysMenu menu = new SysMenu();
        menu.setCode(menuAddRequest.getCode());
        menu.setName(menuAddRequest.getName());
        menu.setParentId(menuAddRequest.getParentId());

        SysUser currentUser = userService.getLoginUser();
        Long userId = currentUser.getId();
        menu.setCreateBy(userId);

        // 如果插入的当前节点为根节点，parentId指定为0
        if (menu.getParentId().longValue() == 0) {
            menu.setLevel(1);// 根节点层级为1
            menu.setNodeType(1);// 根节点类型为1
            menu.setPath(null);// 根节点路径为
        } else {
            SysMenu parentMenu = baseMapper.selectById(menu.getParentId());
            if (parentMenu == null) {
                throw new RuntimeException("未查询到对应的父节点");
            }
            menu.setLevel(parentMenu.getLevel().intValue() + 1);
            menu.setNodeType(parentMenu.getNodeType().intValue() + 1);
            if (StringUtils.isNotEmpty(parentMenu.getPath())) {
                menu.setPath(parentMenu.getPath() + "," + parentMenu.getId());
            } else {
                menu.setPath(parentMenu.getId().toString());
                //     查询同样父路径下的最大排序
                QueryWrapper<SysMenu> menuQueryWrapper = new QueryWrapper<>();
                menuQueryWrapper.eq("parent_id", parentMenu.getId())
                        .orderByDesc("sort").last("limit 1");
                SysMenu maxSortMenu = baseMapper.selectOne(menuQueryWrapper);
                if (maxSortMenu.getSort() != null) {
                    menu.setSort(maxSortMenu.getSort() + 1);
                }
            }
        }

        super.save(menu);
    }

    /**
     * 封装菜单视图
     *
     * @param allMenu
     * @param parentId
     * @return
     */
    private List<MenuVO> transferMenuVo(List<SysMenu> allMenu, Long parentId) {
        List<MenuVO> resultList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(allMenu)) {
            for (SysMenu source : allMenu) {
                if (parentId.longValue() == source.getParentId().longValue()) {
                    MenuVO menuVo = new MenuVO();
                    BeanUtils.copyProperties(source, menuVo);
                    // 递归查询子菜单，并封装信息
                    List<MenuVO> childList = transferMenuVo(allMenu, source.getId());
                    if (!CollectionUtils.isEmpty(childList)) {
                        menuVo.setChildMenu(childList);
                    }
                    resultList.add(menuVo);
                }
            }
        }
        return resultList;
    }
}





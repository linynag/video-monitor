package com.yiwei.web.domain.sysMenu;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class MenuVO implements Serializable {

    public static final long serialVersionUID = -2851202385369647045L;
    /**
     * 子菜单集合
     */
    List<MenuVO> childMenu;
    /**
     * 主键
     */
    private Long id;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 父类id
     */
    private Long parentId;
    /**
     * 路径
     */
    private String path;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 节点类型，1根节点,2菜单,3页面,4按钮
     */
    private Integer nodeType;
    /**
     * 页面对应地址
     */
    private String linkUrl;
    /**
     * 图标地址
     */
    private String iconUrl;
}

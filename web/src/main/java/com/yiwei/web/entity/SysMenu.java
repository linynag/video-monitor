package com.yiwei.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 菜单功能表
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Data
@Component
public class SysMenu implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
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

    /**
     * 是否删除，0否，1是
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建用户id
     */
    private Long createBy;

    /**
     * 修改用户id
     */
    private Long updateBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
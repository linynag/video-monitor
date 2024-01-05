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
@ApiModel("菜单实体类")
public class SysMenu implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键",hidden = true)
    private Long id;

    /**
     * 编码
     */
    @ApiModelProperty(value = "编码")
    private String code;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 父类id
     */
    @ApiModelProperty(value = "父类id")
    private Long parentId;

    /**
     * 路径
     */
    @ApiModelProperty(value = "路径")
    private String path;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 等级
     */
    @ApiModelProperty(value = "等级")
    private Integer level;

    /**
     * 节点类型，1根节点,2菜单,3页面,4按钮
     */
    @ApiModelProperty(value = "节点类型，1根节点,2菜单,3页面,4按钮")
    private Integer nodeType;

    /**
     * 页面对应地址
     */
    @ApiModelProperty(value = "页面对应地址")
    private String linkUrl;

    /**
     * 图标地址
     */
    @ApiModelProperty(value = "图标地址")
    private String iconUrl;

    /**
     * 是否删除，0否，1是
     */
    @ApiModelProperty(value = "是否删除，0否，1是",hidden = true)
    private Integer isDelete;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",hidden = true)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间",hidden = true)
    private LocalDateTime updateTime;

    /**
     * 创建用户id
     */
    @ApiModelProperty(value = "创建用户id",hidden = true)
    private Long createBy;

    /**
     * 修改用户id
     */
    @ApiModelProperty(value = "修改用户id",hidden = true)
    private Long updateBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
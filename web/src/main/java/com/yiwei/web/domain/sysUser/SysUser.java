package com.yiwei.web.domain.sysUser;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户表
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
public class SysUser implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户状态，0无效，1有效
     */
    private Integer status;

    /**
     * 用户所属组织
     */
    private Long orgId;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别，1男，2女
     */
    private Integer sex;

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
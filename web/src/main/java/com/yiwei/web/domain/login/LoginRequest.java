package com.yiwei.web.domain.login;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 登录请求
 */

@Data
public class LoginRequest implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 6706182505031608748L;
    /**
     * 用户账号
     */
    private String account;
    /**
     * 用户密码
     */
    private String password;

}
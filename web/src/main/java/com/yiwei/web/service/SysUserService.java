package com.yiwei.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yiwei.common.ResponseResult;
import com.yiwei.web.domain.login.LoginRequest;
import com.yiwei.web.entity.SysUser;

import javax.servlet.http.HttpServletRequest;

/**
 * @author EDY
 * @description 针对表【sys_user(用户表)】的数据库操作Service
 * @createDate 2024-01-03 11:19:27
 */
public interface SysUserService extends IService<SysUser> {
    ResponseResult login(LoginRequest loginRequest);

    ResponseResult logout();


    /**
     * 获取当前登录用户
     *
     * @param
     * @return
     */
    SysUser getLoginUser();
}

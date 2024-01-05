package com.yiwei.web.service;

import com.yiwei.common.ResponseResult;
import com.yiwei.web.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author EDY
* @description 针对表【sys_user(用户表)】的数据库操作Service
* @createDate 2024-01-03 11:19:27
*/
public interface SysUserService extends IService<SysUser> {
    ResponseResult login(SysUser user);

    ResponseResult logout();
}

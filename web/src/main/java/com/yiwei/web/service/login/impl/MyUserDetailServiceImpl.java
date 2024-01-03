package com.yiwei.web.service.login.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.yiwei.web.domain.login.LoginUser;
import com.yiwei.web.domain.sysUser.SysUser;
import com.yiwei.web.mapper.sysUser.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/11 0011 20:39
 */
@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    //UserDetails是Security官方提供的接口
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount,account);
        SysUser user = userMapper.selectOne(queryWrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }
        //把查询到的user结果，封装成UserDetails类型，然后返回。
        //但是由于UserDetails是个接口，所以我们先需要在domain目录新建LoginUser类，作为UserDetails的实现类，再写下面那行
        return new LoginUser(user);
    }
}
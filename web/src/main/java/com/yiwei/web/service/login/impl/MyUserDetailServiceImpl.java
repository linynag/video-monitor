package com.yiwei.web.service.login.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yiwei.web.domain.login.LoginUser;
import com.yiwei.web.domain.sysUser.SysUser;
import com.yiwei.web.mapper.SysMenuMapper;
import com.yiwei.web.mapper.sysUser.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 重写 MyUserDetailServiceImpl 的 loadUserByUsername
 * 更换为本项目的数据库用户表的登录信息
 */
@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysMenuMapper menuMapper;


    @Override
    // UserDetails是Security官方提供的接口
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount, account);
        SysUser user = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或者密码错误");
        }

        //--------------------------------查询用户权限信息---------------------------------

        // 由于我们自定义了3个权限，所以用List集合存储。注意权限实际就是'有特殊含义的字符串'，所以下面的三个字符串就是自定义的
        // 下面那行就是我们的权限集合，等下还要在LoginUser类做权限集合的转换

        //-------------------------------查询来自数据库的权限信息--------------------------------
        // List<String> list = new ArrayList<>(Arrays.asList("list", "adminAuth", "huanfAuth"));
        List<String> list = menuMapper.selectPermsByUserId(user.getId());

        // 把查询到的user结果，封装成UserDetails类型，然后返回。
        // 但是由于UserDetails是个接口，所以我们先需要在domain目录新建LoginUser类，作为UserDetails的实现类，再写下面那行
        return new LoginUser(user, list);
    }
}
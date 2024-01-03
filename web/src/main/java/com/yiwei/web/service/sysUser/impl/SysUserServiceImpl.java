package com.yiwei.web.service.sysUser.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yiwei.common.ResponseResult;
import com.yiwei.utils.JwtUtil;
import com.yiwei.utils.RedisCache;
import com.yiwei.web.domain.login.LoginUser;
import com.yiwei.web.domain.sysUser.SysUser;
import com.yiwei.web.mapper.sysUser.SysUserMapper;
import com.yiwei.web.service.sysUser.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author EDY
 * @description 针对表【sys_user(用户表)】的数据库操作Service实现
 * @createDate 2024-01-03 11:19:27
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    @Autowired
    // 先在SecurityConfig，使用@Bean注解重写官方的authenticationManagerBean类，然后这里才能注入成功
    private AuthenticationManager authenticationManager;

    @Autowired
    // RedisCache是我们在utils目录写好的类
    private RedisCache redisCache;

    @Override
    @Transactional
    // ResponseResult和user是我们在domain目录写好的类
    public ResponseResult login(SysUser user) {

        // 用户在登录页面输入的用户名和密码
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getAccount(), user.getPassword());
        // 获取AuthenticationManager的authenticate方法来进行用户认证
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 判断上面那行的authenticate是否为null，如果是则认证没通过，就抛出异常
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }

        // 如果认证通过，就使用userid生成一个jwt，然后把jwt存入ResponseResult后返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);

        // 把完整的用户信息存入redis，其中userid作为key，注意存入redis的时候加了前缀 login:
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);
        redisCache.setCacheObject("login:" + userid, loginUser);
        return new ResponseResult(200, "登录成功", map);
    }
}





package com.yiwei.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yiwei.common.ResponseResult;
import com.yiwei.utils.JwtUtil;
import com.yiwei.utils.RedisCache;
import com.yiwei.web.domain.LoginUser;
import com.yiwei.web.domain.login.LoginRequest;
import com.yiwei.web.entity.SysUser;
import com.yiwei.web.mapper.SysUserMapper;
import com.yiwei.web.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
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
    // ResponseResult和user是我们在domain目录写好的类
    public ResponseResult login(LoginRequest loginRequest) {

        // 用户在登录页面输入的用户名和密码
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getAccount(), loginRequest.getPassword());
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

    @Override
    public ResponseResult logout() {

        // 获取我们在JwtAuthenticationTokenFilter类写的SecurityContextHolder对象中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        // loginUser是我们在domain目录写好的实体类
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 获取用户id
        Long userid = loginUser.getUser().getId();

        // 根据用户id，删除redis中的token值，注意我们的key是被 login: 拼接过的，所以下面写完整key的时候要带上 longin:
        redisCache.deleteObject("login:" + userid);

        return new ResponseResult(200, "注销成功");
    }

    @Override
    public SysUser getCurrentUser() {
        // 获取登录人
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser currentUser = (LoginUser) authentication.getPrincipal();
        return currentUser.getUser();
    }
}





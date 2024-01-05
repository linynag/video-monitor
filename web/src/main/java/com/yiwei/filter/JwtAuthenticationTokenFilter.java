package com.yiwei.filter;

import com.yiwei.utils.JwtUtil;
import com.yiwei.utils.RedisCache;
import com.yiwei.web.domain.LoginUser;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/12 0012 14:07
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String xxtoken = request.getHeader("token");
        // 判空，不一定所有的请求都有请求头，所以上面那行的xxtoken可能为空
        if (!StringUtils.hasText(xxtoken)) {
            filterChain.doFilter(request, response);
            return;
        }
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(xxtoken);
            userid = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        String redisKey = "login:" + userid;
        LoginUser loginUser = redisCache.getCacheObject(redisKey);
        // redis里面可能并不存在这个用户信息，例如缓存过期了
        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("用户未登录");
        }

        // 把最终的LoginUser用户信息，通过setAuthentication方法，存入SecurityContextHolder
        // TODO 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken =
                // 第一个参数是LoginUser用户信息，第二个参数是凭证(null)，第三个参数是权限信息()
                new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 全部做完之后，就放行
        filterChain.doFilter(request, response);
    }
}
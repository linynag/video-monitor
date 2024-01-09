package com.yiwei.handler;


import com.alibaba.fastjson2.JSON;
import com.yiwei.common.ResponseResult;
import com.yiwei.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理类
 * 这个类只处理认证异常，不处理授权异常
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    // 把异常封装成授权的对象，然后封装到handle方法
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // ResponseResult是我们在domain目录写好的实体类。HttpStatus是spring提供的枚举类，UNAUTHORIZED表示401状态码
        ResponseResult result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "用户认证失败，请重新登录");
        // 把上面那行拿到的result对象转换为JSON字符串
        String json = JSON.toJSONString(result);
        // WebUtils是我们在utils目录写好的类
        WebUtils.renderString(response, json);
    }
}
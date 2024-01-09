package com.yiwei.handler;


import com.alibaba.fastjson2.JSON;
import com.yiwei.common.ResponseResult;
import com.yiwei.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拒绝访问处理类
 * 这个类只处理授权异常，不处理认证异常
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    // 把异常封装成认证的对象，然后封装到handle方法
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // ResponseResult是我们在domain目录写好的实体类。HttpStatus是spring提供的枚举类，FORBIDDEN表示403状态码
        ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(), "您没有权限进行访问");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
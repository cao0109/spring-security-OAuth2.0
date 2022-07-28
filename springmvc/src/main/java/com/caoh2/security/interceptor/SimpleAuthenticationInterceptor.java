package com.caoh2.security.interceptor;

import com.caoh2.security.model.UserDto;
import com.sun.corba.se.spi.ior.WriteContents;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 简单认证拦截器
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    //请求拦截方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session中的用户信息
        Object userObj = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (userObj == null) {
            //用户未登录，跳转到登录页面
            writeContent(response,"请登录");
            return false;
        }
        UserDto user = (UserDto) userObj;//获取用户信息

        //请求的资源是否需要登录认证
        String requestURI = request.getRequestURI();
        if (user.getAuthorities().contains("p1") && requestURI.contains("/r1")) {
            return true;
        }
        if (user.getAuthorities().contains("p2") && requestURI.contains("/r2")) {
            return true;
        }
        writeContent(response, "没有权限访问");
        return true;
    }

    //响应输出
    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html;charset=utf‐8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
        response.resetBuffer();
    }
}

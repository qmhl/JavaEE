package com.zhangqi.javaee.Filter;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 需要通过   FilterRegistrationBean进行注册
 */
public class LogCostFilter implements Filter {

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Object ob=session.getAttribute("token");
        if(ob==null &&  !request.getServletPath().equals("/checkLogin")){//自己没有登录
            //跳转到专门的 页面 去查询 登录服务器有木有登录
//            response.sendRedirect("/checkLogin");

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("message", "nihao");
            data.put("status", "000000");
            String str = JSONObject.toJSONString(data);
                response.getOutputStream().write(str.getBytes("utf-8"));
                response.getOutputStream().flush();

            return ;
        }else{
            //  条件满足 放行  不满足 就返回
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
 
    }
}
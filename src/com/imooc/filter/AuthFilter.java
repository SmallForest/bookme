package com.imooc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) servletRequest;
        if (hsr.getSession().getAttribute("username") == null) {
            hsr.getRequestDispatcher("/index.jsp?s=1").forward(servletRequest, servletResponse);
            return;
        }
        // 记得释放过滤器，否则页面空白
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("权限过滤器启动》》》");
    }

    @Override
    public void destroy() {
        System.out.println("权限过滤器销毁》》》");
    }
}

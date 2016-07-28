package com.sxc.testweb.filter;

import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Description: MyFilter
 *
 * @author: weimengchao
 * @version: 1.0
 * Create: 2016/5/31
 * Copyright: Copyright (c)2016
 * Company: songxiaocai
 * -
 * Modification History:
 * Date              Author      Version     Description
 * —————————————————————————————————
 * 2016/5/31       weimengchao    1.0       1.0 Version
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter{

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MyFilter.class);

    private FilterConfig config;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext context = config.getServletContext();
        // 预处理
        long before = System.currentTimeMillis();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("MyFilter已经截获用户的请求，地址：" + request.getServletPath());
        // 放行，依然请求目标地址
        filterChain.doFilter(servletRequest, servletResponse);
        // 后处理
        long after = System.currentTimeMillis();
        System.out.println("请求被定位到" + request.getRequestURI()
                + "所花时间为" + (after - before));

    }

    public void destroy() {
        this.config = null;
    }
}

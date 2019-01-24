package com.zhangtai.demo.filter;



import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangtai
 * @date 2019/1/21 22:08
 * @Description:
 */
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //response.setHeader("Cache-Control","no-store");//第二次请求包括css,js,png,jpg,ico和请求
        //response.setHeader("Cache-Control","Public");//第二次请求包括ico和请求
        //response.setHeader("Cache-Control","Private");//第二次请求包括ico和请求
        //response.setHeader("Cache-Control","no-cache");//第二次请求包括css,js,png,jpg,ico和请求
        response.setHeader("Cache-Control","max-age=60");//60秒之内只有请求和ico,60秒之后第二次请求包括css,js,png,jpg,ico和请求
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL.toString()+"-------requestURL----------");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

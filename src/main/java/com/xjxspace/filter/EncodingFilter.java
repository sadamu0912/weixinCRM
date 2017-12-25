package com.xjxspace.filter;

import javax.servlet.annotation.WebFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
@WebFilter(filterName="encodingFilter",urlPatterns="/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig arg0) throws ServletException {
 
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        filterChain.doFilter(request, response);
    }
 
    @Override
    public void destroy() {
         
    }
 
}

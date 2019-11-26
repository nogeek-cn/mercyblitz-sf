package com.darian.springbootweb.spring.boot;


import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MyFilter2 extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        ServletContext servletContext = httpServletRequest.getServletContext();
//        String requestURI = httpServletRequest.getRequestURI();
//        servletContext.log(requestURI + "/MyFilter2 was fitered!");
        doSomething();
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    public void doSomething(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        String requestURI = httpServletRequest.getRequestURI();
        ServletContext servletContext = httpServletRequest.getServletContext();
        servletContext.log(requestURI + "/MyFilter2 was fitered!");

    }
}

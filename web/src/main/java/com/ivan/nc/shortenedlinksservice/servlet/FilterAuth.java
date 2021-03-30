package com.ivan.nc.shortenedlinksservice.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterAuth implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        if (session ==null || session.getAttribute("loggedInUser") == null){
            System.out.println("filter if");
            System.out.println("1"+session);
            response.sendRedirect("login");
            System.out.println("2"+session);
        }else{
            System.out.println("filter else");
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}

package com.example.user_register_ee.filter;

import com.example.user_register_ee.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.user_register_ee.util.AppConstants.CURRENT_USER;

@WebFilter(urlPatterns = {"/user-home"})
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        User currentUser = (User) ((HttpServletRequest)servletRequest).getSession().getAttribute(CURRENT_USER);
        if(currentUser==null){
            ((HttpServletResponse) servletResponse).sendRedirect("/home");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

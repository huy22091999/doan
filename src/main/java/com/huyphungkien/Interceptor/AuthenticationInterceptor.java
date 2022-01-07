package com.huyphungkien.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(session.getAttribute("username")!=null)
        {
            return true;
        }
        session.setAttribute("redirect-uri",request.getRequestURI());
        response.sendRedirect("/adminlogin");
        return false;
    }
}

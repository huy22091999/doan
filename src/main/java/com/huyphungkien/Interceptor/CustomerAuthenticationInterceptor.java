package com.huyphungkien.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Component
public class CustomerAuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    HttpSession httpSession;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(httpSession.getAttribute("customerId")!=null){
            return true;
        }
        if(request.getMethod()!="GET"){
//            Cookie[] cookie=request.getCookies();
//            httpSession.setAttribute("cookies",cookie);
            httpSession.setAttribute("redirect-uri1","/");
        }else
        httpSession.setAttribute("redirect-uri1",request.getRequestURI());
        response.sendRedirect("/login");
        return false;
    }
}

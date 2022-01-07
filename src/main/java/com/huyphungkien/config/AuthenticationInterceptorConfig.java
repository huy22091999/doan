package com.huyphungkien.config;

import com.huyphungkien.Interceptor.AuthenticationInterceptor;
import com.huyphungkien.Interceptor.CustomerAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class AuthenticationInterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private AuthenticationInterceptor ai;
    @Autowired
    private CustomerAuthenticationInterceptor cai;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ai).addPathPatterns("/adminn/***");
        registry.addInterceptor(cai).addPathPatterns("/cartn/***");
        registry.addInterceptor(cai).addPathPatterns("/ordern/***");

    }
}

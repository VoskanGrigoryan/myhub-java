package com.voskan.myhub.security;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig { //FILTER WILL RUN BEFORE CONTROLLERS SO IT SECURITY CHECKS AUTH BEFORE REQ

    @Bean
    public FilterRegistrationBean<Filter> jwtFilter(JwtAuthenticationFilter jwtAuthenticationFilter) {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtAuthenticationFilter);
        registrationBean.addUrlPatterns("/api/*"); // Apply to API routes only
        registrationBean.setOrder(1);
        return registrationBean;
    }
}

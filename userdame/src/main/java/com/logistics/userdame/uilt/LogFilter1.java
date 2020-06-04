package com.logistics.userdame.uilt;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class LogFilter1 {
    /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(myFilter());
        //拦截/*的访问 多级匹配（springboot 过滤器/*以及匹配 /**多级匹配）
        registration.addUrlPatterns("/*");
        registration.setName("myFilter");
        return registration;
    }

    /**
     * 创建一个bean
     * @return
     */
    @Bean(name = "myFilter")
    public Filter myFilter() {
//        拦截的方法
        return new LogFilter();
    }
}

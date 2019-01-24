package com.zhangtai.demo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangtai
 * @date 2019/1/21 22:25
 * @Description:
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean  registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
}

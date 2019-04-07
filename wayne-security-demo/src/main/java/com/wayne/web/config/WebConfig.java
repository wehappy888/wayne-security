package com.wayne.web.config;

import com.wayne.web.interceptor.TimeInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author waynewang
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Bean
    public FilterRegistrationBean encodingFilter() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8",true,true);
        filterRegistrationBean.setFilter(encodingFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        TimeInterceptor timeInterceptor = new TimeInterceptor();
        registry.addInterceptor(timeInterceptor);
    }
}

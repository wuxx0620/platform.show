package com.sureal.config;

import com.sureal.interceptor.ChangeViewInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Wuxx
 * @date 2019/6/13 20:35
 * @PackageName com.sureal.config
 * @ClassName WebConfigurer
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    private ChangeViewInterceptor changeViewInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(changeViewInterceptor).addPathPatterns("/**").
                excludePathPatterns("/login", "/css/**", "/js/**", "/imags/**","/error");
    }


}

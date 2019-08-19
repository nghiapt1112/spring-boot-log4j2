package com.nghia.ivector.infrastructure.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
//                "/resources/**",
//                "/webjars/**",
                "/img/**",
                "/js/**",
                "/css/**",
                "/fonts/**"
        ).addResourceLocations(
//                "classpath:/META-INF/resources/webjars/",
                "classpath:/static/img/",
                "classpath:/static/js/",
                "classpath:/static/css/",
                "classpath:/static/fonts/"
        );
    }

}

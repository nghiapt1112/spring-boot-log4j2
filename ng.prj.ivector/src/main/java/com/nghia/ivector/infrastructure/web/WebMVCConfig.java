package com.nghia.ivector.infrastructure.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/resources/**",
//                "/webjars/**",
                "/images/**",
                "/js/**",
                "/css/**",
                "/fonts/**"
        ).addResourceLocations(
//                "classpath:/META-INF/resources/webjars/",
                "classpath:/static/images/",
                "classpath:/static/js/",
                "classpath:/static/css/",
                "classpath:/static/fonts/"
        );
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://allowed-origin.com")
//                .allowedMethods("PUT")
//                .allowedHeaders("Baeldung-Allowed", "Baledung-Another-Allowed")
//                .exposedHeaders("Baeldung-Allowed", "Baeldung-Exposed")
//                .maxAge(3600);
//    }
}

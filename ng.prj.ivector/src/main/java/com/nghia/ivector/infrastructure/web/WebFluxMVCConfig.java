//package com.nghia.ivector.infrastructure.web;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.config.EnableWebFlux;
//import org.springframework.web.reactive.config.ResourceHandlerRegistry;
//import org.springframework.web.reactive.config.WebFluxConfigurer;
//import org.springframework.web.reactive.result.view.ViewResolver;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ITemplateResolver;
//
//@Configuration
//public class WebFluxMVCConfig implements WebFluxConfigurer {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(
////                "/resources/**",
////                "/webjars/**",
//                "/img/**",
//                "/js/**",
//                "/css/**",
//                "/fonts/**"
//        ).addResourceLocations(
////                "classpath:/META-INF/resources/webjars/",
//                "classpath:/static/img/",
//                "classpath:/static/js/",
//                "classpath:/static/css/",
//                "classpath:/static/fonts/"
//        );
//    }
//
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/resources/**", "/css/**")
////                .addResourceLocations("/WEB-INF/resources/", "/WEB-INF/css/");
////    }
//
//}

package com.nghia.ivector.controller;

import com.nghia.ivector.domain.common.Handler1;
import com.nghia.ivector.domain.common.Handler2;
import com.nghia.ivector.domain.common.Handler3;
import com.nghia.ivector.domain.common.Handler4;
import com.nghia.ivector.domain.common.Handler5;
import com.nghia.ivector.domain.user.User;
import com.nghia.ivector.domain.user.service.UserServiceImpl;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//import com.nghia.ivector.infrastructure.web.ExampleHandlerFilterFunction;

@Configuration
public class UserRouter {
    // solution
    @Bean
    public RouterFunction<ServerResponse> peopleRoutes(UserServiceImpl userService) {
        return RouterFunctions.
                route(
                        GET("/people/{id}").and(accept(APPLICATION_JSON)),
                        req -> ok().body(userService.findById(req.pathVariable("id")), User.class))
                .andRoute(
                        POST("/profile").and(accept(APPLICATION_JSON)),
                        req -> req.body(toMono(User.class)).doOnNext(userService::save)
                        .then(ok().build())
                )
//                .filter(new ExampleHandlerFilterFunction())
//                .andRoute(GET("/people").and(accept(APPLICATION_JSON)), personHandler::all)
//                .andRoute(POST("/people").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), personHandler::post)
//                .andRoute(PUT("/people/{id}").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), personHandler::put)
//                .andRoute(DELETE("/people/{id}"), personHandler::delete)
//                .andRoute(GET("/people/country/{country}").and(accept(APPLICATION_JSON)), personHandler::getByCountry)
                ;
    }

    @Bean
    public RouterFunction<ServerResponse> routeRequest1(Handler1 handler1) {
        return RouterFunctions.route(RequestPredicates.GET("/api/endpoint1")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler1::handleRequest1);
    }

    @Bean
    public RouterFunction<ServerResponse> routeRequest2(Handler2 handler2) {
        return RouterFunctions.route(RequestPredicates.GET("/api/endpoint2")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler2::handleRequest2);
    }

    @Bean
    public RouterFunction<ServerResponse> routeRequest3(Handler3 handler3) {
        return RouterFunctions.route(RequestPredicates.GET("/api/endpoint3")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler3::handleRequest3);
    }

    @Bean
    public RouterFunction<ServerResponse> routeRequest4(Handler4 handler4) {
        return RouterFunctions.route(RequestPredicates.GET("/api/endpoint4")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler4::handleRequest4);
    }

    @Bean
    public RouterFunction<ServerResponse> routeRequest5(Handler5 handler5) {
        return RouterFunctions.route(RequestPredicates.GET("/api/endpoint5")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler5::handleRequest5);
    }
}
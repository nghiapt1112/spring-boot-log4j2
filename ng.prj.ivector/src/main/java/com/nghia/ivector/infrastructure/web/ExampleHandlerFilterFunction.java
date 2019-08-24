package com.nghia.ivector.infrastructure.web;

import com.nghia.ivector.infrastructure.utils.JsonUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.FORBIDDEN;

public class ExampleHandlerFilterFunction implements HandlerFilterFunction<ServerResponse, ServerResponse> {

    @Override
    public Mono<ServerResponse> filter(ServerRequest serverRequest, HandlerFunction<ServerResponse> handlerFunction) {
        try {
            System.out.println(JsonUtils.toJson(SecurityContextHolder.getContext().getAuthentication()));
        } catch (Exception e) {
//            e.printStackTrace();
        }
        if (serverRequest.pathVariable("id").equalsIgnoreCase("test")) {
            return ServerResponse.status(FORBIDDEN).build();
        }
        return handlerFunction.handle(serverRequest);
    }
}
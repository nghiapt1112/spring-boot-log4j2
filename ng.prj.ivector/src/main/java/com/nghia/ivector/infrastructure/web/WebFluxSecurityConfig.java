package com.nghia.ivector.infrastructure.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.WebFilterChainServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import reactor.core.publisher.Mono;

@EnableWebFluxSecurity
public class WebFluxSecurityConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange()
                .pathMatchers("/resources**","resources**","/canvasjschart**").permitAll()
                .anyExchange().authenticated()
                .and().formLogin()
//                .loginPage("/login")
                .authenticationFailureHandler((exchange, exception) -> Mono.error(exception))
//                .authenticationSuccessHandler(new WebFilterChainServerAuthenticationSuccessHandler())
//                .and()
//                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
//                .exceptionHandling()
//                .authenticationEntryPoint((exchange, exception) -> Mono.error(exception))
//                .accessDeniedHandler((exchange, exception) -> Mono.error(exception))
                .and()
                .csrf().disable()
                .logout().disable()
//                .and()
                .build();
    }
}

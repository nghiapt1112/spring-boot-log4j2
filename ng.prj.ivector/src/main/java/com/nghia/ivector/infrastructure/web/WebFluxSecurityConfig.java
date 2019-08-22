package com.nghia.ivector.infrastructure.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class WebFluxSecurityConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Bean
//    public MapReactiveUserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//                .passwordEncoder(passwordEncoder::encode)
//                .username("nghia")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new MapReactiveUserDetailsService(user);
//    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .httpBasic().and()
                .formLogin()
//                .loginPage("/login")

        ;
        return http.build();
    }
}

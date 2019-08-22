package com.nghia.ivector.domain.user;

import com.nghia.ivector.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service(value = "userDetailsService")
public class MyReactiveUserDetailsService implements ReactiveUserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository
                .findByEmail(username)
                .switchIfEmpty(Mono.defer(() -> Mono.error(new UsernameNotFoundException("User Not Found"))))
                .map(Function.identity());
    }
}
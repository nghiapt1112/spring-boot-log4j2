package com.nghia.ivector.domain.user.service;

import com.nghia.ivector.domain.user.User;
import com.nghia.ivector.domain.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }

    public void save(User user) {
        logger.info("Update user with info: {}", user);
    }
}

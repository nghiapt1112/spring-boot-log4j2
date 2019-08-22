package com.nghia.ivector.domain.user.repository;

import com.nghia.ivector.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
//    Optional<User> findByEmail(String email);

//    Optional<User> findById(String id);

    Mono<User> findByEmail(String username);
}

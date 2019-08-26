package com.nghia.ivector.ivector;

import com.nghia.ivector.domain.user.Role;
import com.nghia.ivector.domain.user.User;
import com.nghia.ivector.domain.user.repository.UserRepository;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserRepositoryTest extends IvectorApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void createUser() {
        Role role = new Role();
        role.setId(new ObjectId().toString());
        role.setName("USER");
        String encodedPassword = passwordEncoder.encode("1");
        List<User> users = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    User user = new User();
                    user.setId(new ObjectId().toString());
                    user.setEmail("user@mail.com" + i);
                    user.setPassword(encodedPassword);
                    user.setRoles(new HashSet<>(Arrays.asList(role)));
                    return user;
                }).collect(Collectors.toList());

//        userRepository
//                .saveAll(users)
//                .subscribe(System.out::println);
//
//        userRepository
//                .findAll()
//                .subscribe(System.out::println);
    }


}

package com.nghia.ivector.domain.user.service;

import com.nghia.ivector.domain.user.Role;
import com.nghia.ivector.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

@Service
public class UserDetailServiceImpl  implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Finding user with" + username);
        User user = new User();
        user.setEmail(username);
        Role role = new Role();
        role.setId(1L);
        role.setName("USER");

        user.setRoles(new HashSet<>(Arrays.asList(role)));
        if (Objects.isNull(user)) {
            //  TODO: throw authenticate Exception cause by: user not existed.
//            throw new UserException(toInteger("err.product.null.code"), toStr("err.product.null.msg"));
        } else {
//            user.hideSensitiveFields();
            return user;
        }
        return user;
    }


}
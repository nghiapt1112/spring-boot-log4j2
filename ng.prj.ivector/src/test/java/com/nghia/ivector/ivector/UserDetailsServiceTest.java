package com.nghia.ivector.ivector;

import com.nghia.ivector.domain.user.MyReactiveUserDetailsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsServiceTest extends IvectorApplicationTests {

    @Autowired
    private MyReactiveUserDetailsService userDetailsService;

    @Test
    public void findUserByEmail() {
        UserDetails user = this.userDetailsService.loadUserByUsername("test@test.com");
        System.out.println();
    }
}

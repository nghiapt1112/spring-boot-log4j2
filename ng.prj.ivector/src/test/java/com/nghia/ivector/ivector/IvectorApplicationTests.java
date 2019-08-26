package com.nghia.ivector.ivector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IvectorApplicationTests {

    @Test
    public void contextLoads() {
        Flux.just("1", "2", "3", "4", "5")
                .map(el -> "qq" + el)
                .subscribe(System.out::println)
        ;
    }

}

package com.nghia.ivector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
//@EnableWebFlux
//@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
@PropertySource(value = {"classpath:i18n/messages.properties"}, encoding = "UTF-8")
public class IvectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IvectorApplication.class, args);
    }

}

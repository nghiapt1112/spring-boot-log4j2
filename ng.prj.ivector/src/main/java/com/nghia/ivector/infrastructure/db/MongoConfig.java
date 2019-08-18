//package com.nghia.ivector.infrastructure.db;
//
//import com.mongodb.reactivestreams.client.MongoClient;
//import com.mongodb.reactivestreams.client.MongoClients;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
//import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
//
//@Configuration
////@EnableReactiveMongoRepositories(basePackages = "com.howtodoinjava.demo.dao")
//@EnableReactiveMongoRepositories(basePackages = "com.nghia.ivector.domain")
//public class MongoConfig extends AbstractReactiveMongoConfiguration {
//    @Value("${app.data.mongodb.port}")
//    private String port;
//
//    @Value("${app.data.mongodb.database}")
//    private String dbName;
//
//    @Override
//    public MongoClient reactiveMongoClient() {
//        return MongoClients.create();
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return dbName;
//    }
//
//    @Bean
//    public ReactiveMongoTemplate reactiveMongoTemplate() {
//        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
//    }
//}
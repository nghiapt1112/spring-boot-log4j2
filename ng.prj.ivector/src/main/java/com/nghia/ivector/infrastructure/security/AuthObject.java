package com.nghia.ivector.infrastructure.security;

import lombok.Data;

import java.util.List;

@Data
public class AuthObject {
    private String serviceId;
    private List<String> path;
    private String expression;

}
package com.nghia.ivector.domain.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@ToString
@Document
public class Role implements GrantedAuthority {
    private String id;

    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
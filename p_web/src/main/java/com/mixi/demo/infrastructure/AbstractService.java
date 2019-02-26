package com.mixi.demo.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.Objects;

public abstract class AbstractService {
    @Autowired
    protected Environment environment;

    protected String toStr(String key) {
        String val = this.environment.getProperty(key);
        return Objects.isNull(val) ? key : val;
    }
}

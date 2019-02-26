package com.example.tut.csv.parser;

import java.lang.reflect.Field;

public class DefaultCSVParser extends Parser {
    public DefaultCSVParser(Field f) {
        super(f);
    }

    @Override
    public String parse(String val) {
        return val;
    }
}

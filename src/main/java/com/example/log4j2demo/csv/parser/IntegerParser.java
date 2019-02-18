package com.example.log4j2demo.csv.parser;

public class IntegerParser extends Parser {

    @Override
    public Object parse(String val) {
        return Integer.valueOf(val);
    }
}

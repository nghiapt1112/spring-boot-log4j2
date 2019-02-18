package com.example.log4j2demo.csv.parser;

public class LongParser extends Parser {
    @Override
    public Object parse(String val) {
        return Long.valueOf(val);
    }
}

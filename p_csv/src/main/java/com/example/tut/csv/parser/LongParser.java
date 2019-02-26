package com.example.tut.csv.parser;

public class LongParser extends Parser {
    @Override
    public Object parse(String val) {
        return Long.valueOf(val);
    }
}

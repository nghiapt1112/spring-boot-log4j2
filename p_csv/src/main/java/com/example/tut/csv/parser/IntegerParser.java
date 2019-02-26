package com.example.tut.csv.parser;

public class IntegerParser extends Parser {

    @Override
    public Object parse(String val) {
        return Integer.valueOf(val);
    }
}

package com.example.tut.csv.parser;


import com.example.tut.csv.annotation.DateTime;

import java.lang.reflect.Field;

public abstract class Parser {
    protected Field f;

    protected Parser() {
    }

    protected Parser(Field f) {
        this.f = f;
    }

    public Parser getParser() {
        if (f.getType() == Integer.class) {
            return new IntegerParser();
        } else if (f.getAnnotation(DateTime.class) != null) {
            return new DateTimeParser(f);
        }
        return this;
    }

    public abstract Object parse(String val);

}

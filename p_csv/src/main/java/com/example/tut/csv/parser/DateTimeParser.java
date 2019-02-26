package com.example.tut.csv.parser;

import com.example.tut.csv.annotation.DateTime;
import com.example.tut.csv.utils.DateTimeUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Date;

public class DateTimeParser extends Parser {
    public DateTimeParser(Field f) {
        super(f);
    }

    @Override
    public Date parse(String val) {
        DateTime dateType = f.getAnnotation(DateTime.class);
        Date dateValue = null;
        if (dateType.defaultValue()) {
            dateValue = DateTimeUtils.currentDate();
        }
        if (StringUtils.isNoneEmpty(val)){
            dateValue = DateTimeUtils.valueOf(dateType.pattern(), val);
        }
        return dateValue;
    }
}

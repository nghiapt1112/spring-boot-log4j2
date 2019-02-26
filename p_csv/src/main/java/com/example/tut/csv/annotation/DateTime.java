package com.example.tut.csv.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@CSVField
public @interface DateTime {
    /**
     * Date-Time with timezone, ISO8601 pattern.
     * @return
     */
    String pattern() default "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    boolean defaultValue() default true;
}

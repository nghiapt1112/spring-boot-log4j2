package com.example.log4j2demo.csv;

import com.example.log4j2demo.csv.annotation.CSVField;

public class UserCSV {
    @CSVField
    private Integer id;

    @CSVField(name = "name")
    private String name;

    @CSVField
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
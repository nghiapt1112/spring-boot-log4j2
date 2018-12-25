package com.example.log4j2demo.csv;

public class CSVColumn {
    private String name;
    private int position;

    public CSVColumn() {
    }

    public CSVColumn(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

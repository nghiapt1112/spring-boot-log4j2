package com.example.tut.csv.object;

import java.util.LinkedHashMap;

public class CSVHeader {
    LinkedHashMap<String, Integer> columns;

    public CSVHeader() {
        this.columns = new LinkedHashMap<>();
    }

    public CSVHeader fromFirstLine(String[] input) {
        for (int i = 0; i < input.length; i++) {
            this.columns.put(input[i], i);
        }
        return this;
    }

}

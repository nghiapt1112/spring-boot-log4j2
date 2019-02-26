package com.example.tut.csv.object;

import java.util.List;

public class CSVResponse<T> {
    private List<T> response;
    private List<CSVError> errors;

    public CSVResponse(List<T> response, List<CSVError> errors) {
        this.response = response;
        this.errors = errors;
    }

    public List<T> getResponse() {
        return response;
    }

    public List<CSVError> getErrors() {
        return errors;
    }
}

package com.example.tut.csv.object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CSVError {
    private int line;
    private String columnName;
    private String description;
    private Exception exception;

}

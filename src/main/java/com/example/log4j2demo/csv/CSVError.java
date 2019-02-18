package com.example.log4j2demo.csv;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class CSVError {
    private int line;
    private String columnName;
    private String description;

}

package com.nghia.ivector.domain.order;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Margin {
    private Integer left;
    private Integer right;
    private Integer top;
    private Integer bottom;
}

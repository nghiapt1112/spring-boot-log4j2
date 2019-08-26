package com.nghia.ivector.domain.order;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Order {
    private String id;
    private String name;
}

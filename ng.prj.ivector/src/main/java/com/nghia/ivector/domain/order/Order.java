package com.nghia.ivector.domain.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@ToString
public class Order {
    private String id;
    private String name;
    private OrderSetting orderSetting;
}

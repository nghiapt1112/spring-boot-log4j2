package com.nghia.ivector.domain.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderRequest {

    private String name;
    private String img;
    private OrderSetting orderSetting;

}

package com.nghia.ivector.domain.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@ToString
public class OrderSetting {
    private Integer bright;
    private Margin margin;
    private Integer transparent;
    private String background; // hex color
    private String textColor; // hex color
    private String borderColor; // hex color
    private String alignment;

}

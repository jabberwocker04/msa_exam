package com.spring_cloud.eureka.client.order.Dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductDto {


    private Long productId;
    private String name;
    private Integer supply_price;


    @JsonCreator
    public static ProductDto fromEntity(Long productId, String name, Integer supply_price) {
        return ProductDto.builder()
                .productId(productId)
                .name(name)
                .supply_price(supply_price)
                .build();

    }

}

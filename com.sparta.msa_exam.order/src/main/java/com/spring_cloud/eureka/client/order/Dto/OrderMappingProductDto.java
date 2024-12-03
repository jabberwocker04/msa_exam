package com.spring_cloud.eureka.client.order.Dto;

import com.spring_cloud.eureka.client.order.Entity.Order;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderMappingProductDto {

    private Long orderId;
    private List<Long> productIds;
    private List<ProductDto> products;


    public OrderMappingProductDto(List<Long> productIds, List<ProductDto> products) {
        this.orderId++;
        this.productIds = productIds;
        this.products = products;

    }

}

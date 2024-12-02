package com.spring_cloud.eureka.client.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponseDto {

    private Long order_id;
    private List<OrderMappingProduct> product_ids;

}

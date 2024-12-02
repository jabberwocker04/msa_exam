package com.spring_cloud.eureka.client.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderMappingProduct {

    private Long id;
    private OrderEntity order;
    private Long product_id;
}

package com.spring_cloud.eureka.client.order.Dto;

import com.spring_cloud.eureka.client.order.Entity.Order;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private Long order_id;
    private List<Long> product_ids;

//    public static OrderDto fromEntity(Order order){
//        return OrderDto.builder()
//                .order_id(order.getOrder_id())
//                .product_ids(order.getProduct_ids())
//                .build();
//    }

}

package com.spring_cloud.eureka.client.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long order_id;

    private List<OrderMappingProduct> orderMappingProducts;

//    @OneToMany("product")
//    private List<Product_ids>;

}

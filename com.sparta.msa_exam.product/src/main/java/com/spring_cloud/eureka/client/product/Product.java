package com.spring_cloud.eureka.client.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "??_product");
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    private String name;
    private Integer supply_price;



//    public Product(ProductDto requestDto){
//        this.product_id = requestDto.getProduct_id();
//        this.name = requestDto.getName();
//        this.supply_price = requestDto.getSupply_price();
//
//    }
}

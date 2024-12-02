package com.spring_cloud.eureka.client.product;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    private Long product_id;
    private String name;
    private Integer supply_price;

    public ProductDto(Product product){
        this.product_id = product.getProduct_id();
        this.name = product.getName();
        this.supply_price = product.getSupply_price();
    }

    public static ProductDto fromEntity(Product product){
        return ProductDto.builder()
                .product_id(product.getProduct_id())
                .name(product.getName())
                .supply_price(product.getSupply_price())
                .build();

    }

}

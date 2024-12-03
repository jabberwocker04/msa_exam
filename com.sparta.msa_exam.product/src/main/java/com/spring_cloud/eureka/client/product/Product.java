package com.spring_cloud.eureka.client.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "msa_product")
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    private String name;
    private Integer supply_price;

}

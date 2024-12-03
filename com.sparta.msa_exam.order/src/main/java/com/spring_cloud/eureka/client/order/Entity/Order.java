package com.spring_cloud.eureka.client.order.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "msa_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ElementCollection
    @CollectionTable(name = "order_productIds", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "product_id")
    private List<Long> productIds;

    public void update(Long orderId, List<Long> productIds) {
        this.orderId = orderId;
        this.productIds = productIds;
    }
}

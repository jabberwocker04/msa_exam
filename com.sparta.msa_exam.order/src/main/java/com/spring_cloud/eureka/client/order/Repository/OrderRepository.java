package com.spring_cloud.eureka.client.order.Repository;

import com.spring_cloud.eureka.client.order.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

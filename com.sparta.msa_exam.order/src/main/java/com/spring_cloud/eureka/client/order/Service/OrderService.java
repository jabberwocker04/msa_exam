package com.spring_cloud.eureka.client.order.Service;

import com.spring_cloud.eureka.client.order.Dto.OrderDto;
import com.spring_cloud.eureka.client.order.Dto.OrderMappingProductDto;
import com.spring_cloud.eureka.client.order.Dto.ProductDto;
import com.spring_cloud.eureka.client.order.Entity.Order;
import com.spring_cloud.eureka.client.order.ProductClient;
import com.spring_cloud.eureka.client.order.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductClient productClient;
    private final OrderRepository orderRepository;


    public Order createOrder(Order order) {

        productClient.getProductsByIds(order.getProductIds()); // ProductId 확인

        return  orderRepository.save(order);
    }

    public Order addOrder(Long orderId, List<Long> productIds) {

        Order order = orderRepository.findById(orderId).get();
        List<Long> existingProductIds = order.getProductIds();
        existingProductIds.addAll(productIds);
        order.setProductIds(existingProductIds);

        return orderRepository.save(order);
    }

    public Order updateOrder(Long orderId, List<Long> productIds) {

        Order order = orderRepository.findById(orderId).get();
        order.update(orderId, productIds);
        return orderRepository.save(order);

    }

    public Order readOrder(Long orderId) {
        return orderRepository.findById(orderId).get();
    }
}

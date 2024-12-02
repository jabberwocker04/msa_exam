package com.spring_cloud.eureka.client.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.createOrder(orderRequestDto);
    }

    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }



}

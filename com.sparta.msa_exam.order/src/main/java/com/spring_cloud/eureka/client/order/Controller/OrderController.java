package com.spring_cloud.eureka.client.order.Controller;

import com.spring_cloud.eureka.client.order.Dto.OrderMappingProductDto;
import com.spring_cloud.eureka.client.order.Dto.ProductDto;
import com.spring_cloud.eureka.client.order.Entity.Order;
import com.spring_cloud.eureka.client.order.ProductClient;
import com.spring_cloud.eureka.client.order.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ProductClient productClient;
    @Value("${server.port}") //
    String ServerPort;

    /*
     * 주문 추가 API
     * */
    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Server-Port", ServerPort);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(orderService.createOrder(order));
    }

}
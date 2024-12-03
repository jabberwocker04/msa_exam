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

    @PutMapping("/orders/{orderId}") // 주문 수정
    public ResponseEntity<Order> addOrder(@PathVariable("orderId") Long orderId, @RequestBody List<Long> productIds) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Server-Port", ServerPort);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(orderService.addOrder(orderId, productIds));
    }

    @PutMapping("/orders/update/{orderId}") // 주문 상품 추가
    public ResponseEntity<Order> updateOrder(@PathVariable("orderId") Long orderId, @RequestBody List<Long> productIds) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Server-Port", ServerPort);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(orderService.updateOrder(orderId, productIds));
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Order> ReadOrder(@PathVariable("orderId") Long orderId) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Server-Port", ServerPort);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(orderService.readOrder(orderId));
    }

}

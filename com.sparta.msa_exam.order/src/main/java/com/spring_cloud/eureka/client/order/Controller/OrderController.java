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

    @Value("${server.port}") //
    String ServerPort;

    /*
     * 주문 생성 API
     * */
    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {

        return ResponseEntity.ok()
                .headers(DefaultHeaders())
                .body(orderService.createOrder(order));
    }

    /*
    * 주문 추가 API
    * */
    @PutMapping("/orders/{orderId}") // 주문 수정
    public ResponseEntity<Order> addOrder(@PathVariable("orderId") Long orderId, @RequestBody List<Long> productIds) {

        return ResponseEntity.ok()
                .headers(DefaultHeaders())
                .body(orderService.addOrder(orderId, productIds));
    }

    /*
    * 주문 수정 API
    * */
    @PutMapping("/orders/update/{orderId}") // 주문 상품 추가
    public ResponseEntity<Order> updateOrder(@PathVariable("orderId") Long orderId, @RequestBody List<Long> productIds) {

        return ResponseEntity.ok()
                .headers(DefaultHeaders())
                .body(orderService.updateOrder(orderId, productIds));
    }

    /*
    * 주문 조회 API
    * */
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Order> ReadOrder(@PathVariable("orderId") Long orderId) {

        return ResponseEntity.ok()
                .headers(DefaultHeaders())
                .body(orderService.readOrder(orderId));
    }

    public HttpHeaders DefaultHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Server-Port", ServerPort);
        return responseHeaders;
    }

}

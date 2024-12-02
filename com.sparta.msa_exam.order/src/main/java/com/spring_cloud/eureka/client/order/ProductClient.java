package com.spring_cloud.eureka.client.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
// Either 'name' or 'value' must be provided in @FeignClient 가 발생했었다.
// 이 오류는 이 FeignClient에서 Name을 지정해주지 않으면 발생한다.
public interface ProductClient {

    @GetMapping("/product/{product_id}")
    String getProduct(@PathVariable("product_id") String product_id); // pathVariable에 ("id")을 안 적어줬어서

    @GetMapping("/products")
    String getProducts();

}

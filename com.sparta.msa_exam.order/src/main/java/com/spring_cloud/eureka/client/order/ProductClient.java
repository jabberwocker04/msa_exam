package com.spring_cloud.eureka.client.order;

import com.spring_cloud.eureka.client.order.Dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {

//    @GetMapping("/products")
//    String getProducts();

    @GetMapping("/products/read/{productId}")
    ProductDto getProductsIds(@PathVariable("productId") Long productId);

    // 다중 상품 조회
    @PostMapping("/products/read")
    List<ProductDto> getProductsByIds(@RequestBody List<Long> productIds);
}

package com.spring_cloud.eureka.client.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

//    @Value("${server.port}")
//    private String serverPort;
//
//    @Value("${message}")
//    private String message;

//    @GetMapping("/product")
//    public String getProduct() {
//        return "Product info! From port : " + serverPort + message;
//    }

    /*
    * 상품 추가 API
    * */
    @PostMapping("/products")
    public ProductDto products(@RequestBody ProductDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }


    /*
    * 상품 목록 조회 API
    * */

    @GetMapping("/products")
    public List<ProductDto> getProducts(){
        return productService.readAllProducts();
    }

    @Value("server.port") // server.port값(19093)을 불러온다.
    String a;

}

package com.spring_cloud.eureka.client.product;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Value("${server.port}") // server.port값(19093)을 불러온다.
    String ServerPort;

    /*
    * 상품 추가 API
    * */
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody ProductDto productRequestDto) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Server-Port", ServerPort);
        productService.createProduct(productRequestDto);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("상품 추가 완료");
    }


    /*
    * 상품 목록 조회 API
    * */
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Server-Port", ServerPort);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(productService.readAllProducts());
    }

    /*
    * Order를 위한 상품 단 건 조회
    * */
    @PostMapping("/products/read")
    public ResponseEntity<List<ProductDto>> getProductsByIds(@RequestBody List<Long> productIds) {
        List<ProductDto> products = productService.findProductByIds(productIds);
        return ResponseEntity.ok(products);
    }

    // Order를 위한 상품 단 건 조회 2차
    @GetMapping("/products/read/{productId}")
//    @Cacheable(value = "products", key = "#productId") // 캐시
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId, HttpServletRequest request) {
        ProductDto product = productService.getProductById(productId);
        return ResponseEntity.ok()
                .header("Server-Port",String.valueOf(request.getLocalPort())) // 헤더에 Server-Port 추가
                .body(product);
    }

}

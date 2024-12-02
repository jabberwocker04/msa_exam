package com.spring_cloud.eureka.client.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductClient productClient;

    public String getProductInfo(String productId) {
        return productClient.getProduct(productId);
    }

    public String getOrder(String product_id) {
        if (product_id.equals(productClient.getProducts().) {
            String productInfo = productClient.getProducts();
            return "Your order is " + orderId + " and " + productInfo;
        } else {
            return "Not exist order";
        }
    }

//    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto){
//
//        return
//    }
}

package com.spring_cloud.eureka.client.order;

import com.spring_cloud.eureka.client.order.Dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductClientFallback implements ProductClient {


    @Override
    public ProductDto getProductsIds(Long productId) {
        return null;
    }

    //fallback 구현
    @Override
    public List<ProductDto>getProductsByIds (List<Long> productIds) {
        System.out.println("잠시 후에 주문 추가를 요청 해주세요.");
        return null;
    }

}

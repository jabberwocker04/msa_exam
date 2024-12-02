package com.spring_cloud.eureka.client.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductDto createProduct(ProductDto productDto) {

        return ProductDto.fromEntity(productRepository.save(Product.builder()
                        .name(productDto.getName())
                        .product_id(productDto.getProduct_id())
                        .supply_price(productDto.getSupply_price())
                .build()));

    }

    @Transactional(readOnly = true)
    public List<ProductDto> readAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductDto::fromEntity)
                .toList();
    }
}

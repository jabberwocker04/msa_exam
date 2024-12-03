package com.spring_cloud.eureka.client.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<ProductDto> findProductByIds(List<Long> product_ids) {
        return product_ids.stream()
                .map(this::getProductById)
                .collect(Collectors.toList());
    }

    // 상품 조회 새 버젼
    @Transactional(readOnly = true)
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        return new ProductDto(product.getProduct_id(), product.getName(), product.getSupply_price());
    }


    private ProductDto convertToDto(Product product) {
        return new ProductDto(product.getProduct_id(), product.getName(), product.getSupply_price());
    }
    //        return product_ids;
//        주문 Entity와 주문 매핑 상품 Entity의 구성이
//                order_id, product_ids와 id, order, product_id
//                order id만 있는 ENtity와
//                RequestDto는 product_ids만 가져오게 하고(1,2,3,4... etc)
//                주문 매핑 상품 Entity는
//                그 후 주문이 만들어진 후의 정보를 그대로 id, order, product_id로 만든다?
//
//                그럼 주문 매핑 상품 Entity의 order는 최소조건으로 id만 들어가도 됌.

    //주문이 일부만 만들어 져서 매핑 되도 되고, 취소가 되어도 된다.
    //가격에 따라 주문이 될 수도 있고(쿠팡) 안될 수도 있게 만들어도 좋겠다.

}

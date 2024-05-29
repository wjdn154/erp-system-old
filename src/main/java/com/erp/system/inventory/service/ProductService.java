package com.erp.system.inventory.service;

import com.erp.system.inventory.model.Product;
import com.erp.system.inventory.repository.ProductRepository;
import java.util.Collection;

/**
 * ProductService 클래스는 제품 관련 비즈니스 로직을 처리하는 서비스 역할.
 * 제품 데이터를 추가하고, 조회하고, 모든 제품 데이터를 반환하는 기능을 제공.
 */
public class ProductService {
    // 제품 데이터를 관리하는 저장소
    private final ProductRepository productRepository = new ProductRepository();

    /**
     * 새로운 제품 데이터를 추가.
     *
     * @param product 추가할 제품 데이터
     */
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    /**
     * 주어진 제품 ID에 해당하는 제품 데이터를 반환.
     *
     * @param productId 조회할 제품 ID
     * @return 해당 제품 ID에 대한 제품 데이터, 없으면 null 반환
     */
    public Product getProduct(String productId) {
        return productRepository.getProduct(productId);
    }

    /**
     * 모든 제품 데이터를 반환.
     *
     * @return 모든 제품 데이터의 컬렉션
     */
    public Collection<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    // 기타 비즈니스 로직
}
package com.erp.system.inventory.repository;
import com.erp.system.inventory.model.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * ProductRepository 클래스는 제품 데이터를 관리하는 저장소 역할.
 * 제품 데이터를 추가하고, 조회하고, 모든 제품 데이터를 반환하는 기능을 제공.
 */
public class ProductRepository {
    // 제품 데이터를 저장하는 맵 (제품 ID를 키로 사용)
    private final Map<String, Product> productMap = new HashMap<>();

    /**
     * 새로운 제품 데이터를 추가.
     *
     * @param product 추가할 제품 데이터
     */
    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    /**
     * 주어진 제품 ID에 해당하는 제품 데이터를 반환.
     *
     * @param productId 조회할 제품 ID
     * @return 해당 제품 ID에 대한 제품 데이터, 없으면 null 반환
     */
    public Product getProduct(String productId) {
        return productMap.get(productId);
    }

    /**
     * 모든 제품 데이터를 반환.
     *
     * @return 모든 제품 데이터의 컬렉션
     */
    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    // 기타 CRUD 메서드
}
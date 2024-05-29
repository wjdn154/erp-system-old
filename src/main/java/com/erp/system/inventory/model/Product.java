package com.erp.system.inventory.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Product 클래스는 제품의 정보를 나타냄.
 * 각 인스턴스는 특정 제품의 이름, 설명, 가격 등을 포함.
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String productId; // 제품의 고유 식별자
    private String productName; // 제품 이름
    private String description; // 제품 설명
    private BigDecimal price; // 제품 가격

    /**
     * Product 생성자.
     *
     * @param productName 제품 이름
     * @param description 제품 설명
     * @param price 제품 가격
     */
    public Product(String productName, String description, BigDecimal price) {
        this.productId = UUID.randomUUID().toString(); // 고유 제품 ID를 생성
        this.productName = productName; // 제품 이름을 설정
        this.description = description; // 제품 설명을 설정
        this.price = price; // 제품 가격을 설정
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
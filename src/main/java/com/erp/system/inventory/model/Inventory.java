package com.erp.system.inventory.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Inventory 클래스는 제품의 재고 정보를 나타냄.
 * 각 인스턴스는 특정 제품의 재고 수량과 위치, 임계값 등을 포함.
 */
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String inventoryId; // 재고의 고유 식별자
    private final String productId; // 제품의 고유 식별자
    private int quantity; // 현재 재고 수량
    private String location; // 재고 위치
    private int threshold; // 임계 재고 수준 (경고 알림을 발생시키는 기준)

    /**
     * Inventory 생성자.
     *
     * @param productId 제품의 고유 식별자
     * @param quantity 현재 재고 수량
     * @param location 재고 위치
     * @param threshold 임계 재고 수준
     */
    public Inventory(String productId, int quantity, String location, int threshold) {
        this.inventoryId = UUID.randomUUID().toString(); // 고유 재고 ID를 생성
        this.productId = productId; // 제품 ID를 설정
        this.quantity = quantity; // 초기 재고 수량을 설정
        this.location = location; // 재고 위치를 설정
        this.threshold = threshold; // 임계 재고 수준을 설정
    }

    // Getters and Setters
    public String getInventoryId() {
        return inventoryId;
    }
    public String getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getThreshold() {
        return threshold;
    }
    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
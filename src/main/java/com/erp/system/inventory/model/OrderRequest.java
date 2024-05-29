package com.erp.system.inventory.model;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * OrderRequest 클래스는 재고 수준이 임계값 이하로 떨어질 때 자동으로 생성되는 주문 요청을 나타냄.
 * 각 인스턴스는 특정 제품의 주문 수량, 주문 날짜 및 상태를 포함.
 */
public class OrderRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String orderId; // 주문 요청의 고유 식별자
    private final String productId; // 제품의 고유 식별자
    private int requestedQuantity; // 요청된 주문 수량
    private Date orderDate; // 주문 요청 날짜 및 시간
    private String status; // 주문 상태 (예: 'Pending', 'Completed')

    /**
     * OrderRequest 생성자.
     *
     * @param productId 제품의 고유 식별자
     * @param requestedQuantity 요청된 주문 수량
     * @param orderDate 주문 요청 날짜 및 시간
     * @param status 주문 상태 (예: 'Pending', 'Completed')
     */
    public OrderRequest(String productId, int requestedQuantity, Date orderDate, String status) {
        this.orderId = UUID.randomUUID().toString(); // 고유 주문 요청 ID를 생성
        this.productId = productId; // 제품 ID를 설정
        this.requestedQuantity = requestedQuantity; // 요청된 주문 수량을 설정
        this.orderDate = orderDate; // 주문 요청 날짜 및 시간을 설정
        this.status = status; // 주문 상태를 설정
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }
    public String getProductId() {
        return productId;
    }
    public int getRequestedQuantity() {
        return requestedQuantity;
    }
    public void setRequestedQuantity(int requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
package com.erp.system.inventory.model;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * InventoryLog 클래스는 재고의 입출고 기록을 나타냄.
 * 각 인스턴스는 특정 제품의 입출고 유형, 수량, 날짜 및 처리자를 포함합니다.
 */
public class InventoryLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String logId; // 로그의 고유 식별자
    private final String productId; // 제품의 고유 식별자
    private String type; // 입출고 유형 ('In' 또는 'Out')
    private int quantity; // 입출고 수량
    private Date date; // 입출고 날짜 및 시간
    private String handledBy; // 로그를 처리한 사람의 이름

    /**
     * InventoryLog 생성자.
     *
     * @param productId 제품의 고유 식별자
     * @param type 입출고 유형 ('In' 또는 'Out')
     * @param quantity 입출고 수량
     * @param date 입출고 날짜 및 시간
     * @param handledBy 로그를 처리한 사람의 이름
     */
    public InventoryLog(String productId, String type, int quantity, Date date, String handledBy) {
        this.logId = UUID.randomUUID().toString(); // 고유 로그 ID를 생성
        this.productId = productId; // 제품 ID를 설정
        this.type = type; // 입출고 유형을 설정
        this.quantity = quantity; // 입출고 수량을 설정
        this.date = date; // 입출고 날짜 및 시간을 설정
        this.handledBy = handledBy; // 로그를 처리한 사람의 이름을 설정
    }

    // Getters and Setters
    public String getLogId() {
        return logId;
    }
    public String getProductId() {
        return productId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getHandledBy() {
        return handledBy;
    }
    public void setHandledBy(String handledBy) {
        this.handledBy = handledBy;
    }
}
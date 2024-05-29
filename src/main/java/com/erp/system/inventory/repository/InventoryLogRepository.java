package com.erp.system.inventory.repository;
import com.erp.system.inventory.model.InventoryLog;

import java.util.ArrayList;
import java.util.List;

/**
 * InventoryLogRepository 클래스는 재고 로그를 관리하는 저장소 역할을 합니다.
 * 재고 로그를 추가하고, 제품 ID에 따라 재고 로그를 조회하는 기능을 제공합니다.
 */
public class InventoryLogRepository {
    // 재고 로그 리스트를 저장하는 인스턴스 변수
    private final List<InventoryLog> inventoryLogList = new ArrayList<>();

    /**
     * 새로운 재고 로그를 추가합니다.
     *
     * @param inventoryLog 추가할 재고 로그
     */
    public void addInventoryLog(InventoryLog inventoryLog) {
        inventoryLogList.add(inventoryLog);
    }

    /**
     * 주어진 제품 ID에 해당하는 모든 재고 로그를 반환.
     *
     * @param productId 조회할 제품 ID
     * @return 해당 제품 ID에 대한 재고 로그 리스트
     */
    public List<InventoryLog> getLogsByProductId(String productId) {
        List<InventoryLog> logs = new ArrayList<>();
        for (InventoryLog log : inventoryLogList) {
            if (log.getProductId().equals(productId)) {
                logs.add(log);
            }
        }
        return logs;
    }

    // 기타 CRUD 메서드
}
package com.erp.system.inventory.repository;
import com.erp.system.inventory.model.Inventory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * InventoryRepository 클래스는 재고 데이터를 관리하는 저장소 역할.
 * 재고 데이터를 추가하고, 조회하고, 모든 재고 데이터를 반환하는 기능을 제공.
 */
public class InventoryRepository {
    // 재고 데이터를 저장하는 맵 (재고 ID를 키로 사용)
    private final Map<String, Inventory> inventoryMap = new HashMap<>();

    /**
     * 새로운 재고 데이터를 추가.
     *
     * @param inventory 추가할 재고 데이터
     */
    public void addInventory(Inventory inventory) {
        inventoryMap.put(inventory.getInventoryId(), inventory);
    }

    /**
     * 주어진 재고 ID에 해당하는 재고 데이터를 반환.
     *
     * @param inventoryId 조회할 재고 ID
     * @return 해당 재고 ID에 대한 재고 데이터, 없으면 null 반환
     */
    public Inventory getInventory(String inventoryId) {
        return inventoryMap.get(inventoryId);
    }

    /**
     * 주어진 제품 ID에 해당하는 재고 데이터를 반환.
     *
     * @param productId 조회할 제품 ID
     * @return 해당 제품 ID에 대한 재고 데이터, 없으면 null 반환
     */
    public Inventory getInventoryByProductId(String productId) {
        return inventoryMap.values().stream()
                .filter(inventory -> inventory.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    /**
     * 모든 재고 데이터를 반환.
     *
     * @return 모든 재고 데이터의 컬렉션
     */
    public Collection<Inventory> getAllInventories() {
        return inventoryMap.values();
    }

    // 기타 CRUD 메서드
}
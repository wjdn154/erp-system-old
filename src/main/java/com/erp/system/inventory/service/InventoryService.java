package com.erp.system.inventory.service;

import com.erp.system.inventory.model.Inventory;
import com.erp.system.inventory.model.InventoryLog;
import com.erp.system.inventory.model.OrderRequest;
import com.erp.system.inventory.repository.InventoryLogRepository;
import com.erp.system.inventory.repository.InventoryRepository;
import com.erp.system.inventory.repository.OrderRequestRepository;
import java.util.Collection;
import java.util.Date;

/**
 * InventoryService 클래스는 재고 관련 비즈니스 로직을 처리하는 서비스 역할.
 * 재고 데이터를 추가하고, 조회하고, 수량을 업데이트하는 기능을 제공.
 */
public class InventoryService {
    // 재고 데이터를 관리하는 저장소
    private final InventoryRepository inventoryRepository = new InventoryRepository();

    // 제품 관련 비즈니스 로직을 처리하는 서비스
    private final ProductService productService;

    /**
     * InventoryService 생성자.
     *
     * @param productService 제품 서비스를 사용하는 InventoryService 초기화
     */
    public InventoryService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 새로운 재고 데이터를 추가.
     *
     * @param inventory 추가할 재고 데이터
     */
    public void addInventory(Inventory inventory) {
        inventoryRepository.addInventory(inventory);
    }

    /**
     * 주어진 재고 ID에 해당하는 재고 데이터를 반환.
     *
     * @param inventoryId 조회할 재고 ID
     * @return 해당 재고 ID에 대한 재고 데이터, 없으면 null 반환
     */
    public Inventory getInventory(String inventoryId) {
        return inventoryRepository.getInventory(inventoryId);
    }

    /**
     * 주어진 제품 ID에 해당하는 재고 수량을 업데이트.
     *
     * @param productId 제품 ID
     * @param quantityChange 변경할 수량 (양수는 입고, 음수는 출고)
     * @param type 입출고 유형 ('In' 또는 'Out')
     * @param handledBy 로그를 처리한 사람의 이름
     */
    public void updateInventoryQuantity(String productId, int quantityChange, String type, String handledBy) {
        Inventory inventory = inventoryRepository.getInventoryByProductId(productId);
        if (inventory != null) {
            int newQuantity = inventory.getQuantity() + quantityChange;
            inventory.setQuantity(newQuantity);

            // 로그 추가
            InventoryLog log = new InventoryLog(productId, type, quantityChange, new Date(), handledBy);
            InventoryLogRepository logRepository = new InventoryLogRepository();
            logRepository.addInventoryLog(log);

            // 임계값 이하일 경우 주문 요청
            if (newQuantity < inventory.getThreshold()) {
                OrderRequest orderRequest = new OrderRequest(productId, inventory.getThreshold() - newQuantity, new Date(), "Pending");
                OrderRequestRepository orderRequestRepository = new OrderRequestRepository();
                orderRequestRepository.addOrderRequest(orderRequest);
            }
        }
    }

    /**
     * 모든 재고 데이터를 반환.
     *
     * @return 모든 재고 데이터의 컬렉션
     */
    public Collection<Inventory> getAllInventories() {
        return inventoryRepository.getAllInventories();
    }

    // 기타 비즈니스 로직
}
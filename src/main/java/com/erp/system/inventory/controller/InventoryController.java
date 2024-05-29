package com.erp.system.inventory.controller;
import com.erp.system.inventory.model.Inventory;
import com.erp.system.inventory.service.InventoryService;
import com.erp.system.inventory.service.ProductService;

import java.util.Collection;
import java.util.Scanner;

/**
 * InventoryController 클래스는 재고 관련 요청을 처리하는 컨트롤러 역할.
 * 사용자의 입력을 받아 재고 데이터를 추가, 수정, 조회하는 기능을 제공.
 */
public class InventoryController {
    private final InventoryService inventoryService;

    /**
     * InventoryController 생성자.
     * ProductService를 받아 InventoryService를 초기화.
     *
     * @param productService 제품 서비스를 사용하는 InventoryService 초기화
     */
    public InventoryController(ProductService productService) {
        this.inventoryService = new InventoryService(productService);
    }

    /**
     * 새로운 재고를 추가하는 메서드.
     * 사용자로부터 입력받은 데이터를 기반으로 재고를 생성하고 추가.
     */
    public void createInventory() {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 제품 ID를 입력받음
        System.out.print("Enter product ID: ");
        String productId = scanner.nextLine();

        // 사용자로부터 수량을 입력받음
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        // 사용자로부터 위치를 입력받음
        System.out.print("Enter location: ");
        String location = scanner.next();

        // 사용자로부터 임계값을 입력받음
        System.out.print("Enter threshold: ");
        int threshold = scanner.nextInt();

        // 입력받은 데이터를 기반으로 Inventory 객체를 생성
        Inventory inventory = new Inventory(productId, quantity, location, threshold);
        // InventoryService를 통해 재고를 추가
        inventoryService.addInventory(inventory);

        System.out.println("Inventory created successfully.");
    }

    /**
     * 재고 수량을 업데이트하는 메서드.
     * 사용자로부터 입력받은 데이터를 기반으로 재고 수량을 변경.
     */
    public void updateInventoryQuantity() {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 제품 ID를 입력받음
        System.out.print("Enter product ID: ");
        String productId = scanner.nextLine();

        // 사용자로부터 수량 변화를 입력받음 (양수는 입고, 음수는 출고)
        System.out.print("Enter quantity change (positive for in, negative for out): ");
        int quantityChange = scanner.nextInt();

        // 사용자로부터 입출고 타입을 입력받음
        System.out.print("Enter type (In/Out): ");
        String type = scanner.next();

        // 사용자로부터 처리자 이름을 입력받음
        System.out.print("Enter handler name: ");
        String handledBy = scanner.next();

        // InventoryService를 통해 재고 수량을 업데이트
        inventoryService.updateInventoryQuantity(productId, quantityChange, type, handledBy);

        System.out.println("Inventory updated successfully.");
    }

    /**
     * 모든 재고 정보를 조회하여 출력하는 메서드.
     */
    public void getAllInventories() {
        // InventoryService를 통해 모든 재고 정보를 조회
        Collection<Inventory> inventories = inventoryService.getAllInventories();
        // 조회한 재고 정보를 출력
        for (Inventory inventory : inventories) {
            System.out.println("Inventory ID: " + inventory.getInventoryId());
            System.out.println("Product ID: " + inventory.getProductId());
            System.out.println("Quantity: " + inventory.getQuantity());
            System.out.println("Location: " + inventory.getLocation());
            System.out.println("Threshold: " + inventory.getThreshold());
            System.out.println("-----------------------------");
        }
    }

    // 기타 핸들러 메서드
}
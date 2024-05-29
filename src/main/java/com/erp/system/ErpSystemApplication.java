package com.erp.system;

import com.erp.system.inventory.controller.InventoryController;
import com.erp.system.inventory.controller.ProductController;
import com.erp.system.inventory.model.Inventory;
import com.erp.system.inventory.model.InventoryLog;
import com.erp.system.inventory.model.OrderRequest;
import com.erp.system.inventory.model.Product;
import com.erp.system.inventory.repository.InventoryLogRepository;
import com.erp.system.inventory.repository.InventoryRepository;
import com.erp.system.inventory.repository.OrderRequestRepository;
import com.erp.system.inventory.repository.ProductRepository;
import com.erp.system.inventory.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class ErpSystemApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ErpSystemApplication.class, args);
		// 서비스 및 컨트롤러 객체 생성
		ProductService productService = new ProductService();
		InventoryController inventoryController = new InventoryController(productService);
		ProductController productController = new ProductController();

		// 사용자 입력을 받기 위한 Scanner 객체 생성
		Scanner scanner = new Scanner(System.in);

		// 사용자와 상호작용(무한 루프)
		while (true) {
			// 메뉴 옵션 출력
			System.out.println("1. Create Product");
			System.out.println("2. View Product Details");
			System.out.println("3. Create Inventory");
			System.out.println("4. Update Inventory Quantity");
			System.out.println("5. View All Products");
			System.out.println("6. View All Inventories");
			System.out.println("0. Exit");
			System.out.print("Choose an option: ");
			int option = scanner.nextInt();

			// 선택한 옵션에 따라 동작 수행
			switch (option) {
				case 1:
					productController.createProduct(); // 제품 생성
					break;
				case 2:
					productController.getProductDetails(); // 특정 제품 상세 정보 조회
					break;
				case 3:
					inventoryController.createInventory(); // 재고 생성
					break;
				case 4:
					inventoryController.updateInventoryQuantity(); // 재고 수량 업데이트
					break;
				case 5:
					productController.getAllProducts(); // 모든 제품 조회
					break;
				case 6:
					inventoryController.getAllInventories(); // 모든 재고 조회
					break;
				case 0:
					System.out.println("Exiting..."); // 프로그램 종료
					return;
				default:
					System.out.println("Invalid option. Please try again."); // 유효하지 않은 옵션 처리
			}
		}
	}
}
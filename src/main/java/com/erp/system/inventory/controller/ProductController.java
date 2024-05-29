package com.erp.system.inventory.controller;
import com.erp.system.inventory.model.Product;
import com.erp.system.inventory.service.ProductService;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Scanner;

/**
 * ProductController 클래스는 제품 관련 요청을 처리하는 컨트롤러 역할.
 * 사용자의 입력을 받아 제품 데이터를 추가, 조회하는 기능을 제공.
 */
public class ProductController {
    private final ProductService productService = new ProductService();

    /**
     * 새로운 제품을 추가하는 메서드.
     * 사용자로부터 입력받은 데이터를 기반으로 제품을 생성하고 추가.
     */
    public void createProduct() {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 제품 이름을 입력받음
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        // 사용자로부터 제품 설명을 입력받음
        System.out.print("Enter product description: ");
        String description = scanner.nextLine();

        // 사용자로부터 제품 가격을 입력받음
        System.out.print("Enter product price: ");
        BigDecimal price = scanner.nextBigDecimal();

        // 입력받은 데이터를 기반으로 Product 객체를 생성
        Product product = new Product(name, description, price);
        // ProductService를 통해 제품을 추가
        productService.addProduct(product);

        System.out.println("Product created successfully.");
    }

    /**
     * 특정 제품의 상세 정보를 조회하는 메서드.
     * 사용자로부터 제품 ID를 입력받아 해당 제품의 정보를 출력.
     */
    public void getProductDetails() {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 제품 ID를 입력받음
        System.out.print("Enter product ID: ");
        String productId = scanner.nextLine();

        // ProductService를 통해 제품 정보를 조회
        Product product = productService.getProduct(productId);
        if (product != null) {
            // 제품 정보를 출력
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Product Description: " + product.getDescription());
            System.out.println("Product Price: " + product.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }

    /**
     * 모든 제품 정보를 조회하여 출력하는 메서드.
     */
    public void getAllProducts() {
        // ProductService를 통해 모든 제품 정보를 조회
        Collection<Product> products = productService.getAllProducts();
        // 조회한 제품 정보를 출력
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Product Description: " + product.getDescription());
            System.out.println("Product Price: " + product.getPrice());
            System.out.println("-----------------------------");
        }
    }

    // 기타 핸들러 메서드
}
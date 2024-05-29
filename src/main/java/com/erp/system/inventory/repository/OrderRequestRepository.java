package com.erp.system.inventory.repository;
import com.erp.system.inventory.model.OrderRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderRequestRepository 클래스는 주문 요청을 관리하는 저장소 역할.
 * 주문 요청을 추가하고, 제품 ID에 따라 주문 요청을 조회하는 기능을 제공.
 */
public class OrderRequestRepository {
    // 주문 요청 리스트를 저장하는 인스턴스 변수
    private final List<OrderRequest> orderRequestList = new ArrayList<>();

    /**
     * 새로운 주문 요청을 추가.
     *
     * @param orderRequest 추가할 주문 요청
     */
    public void addOrderRequest(OrderRequest orderRequest) {
        orderRequestList.add(orderRequest);
    }

    /**
     * 주어진 제품 ID에 해당하는 모든 주문 요청을 반환.
     *
     * @param productId 조회할 제품 ID
     * @return 해당 제품 ID에 대한 주문 요청 리스트
     */
    public List<OrderRequest> getRequestsByProductId(String productId) {
        List<OrderRequest> requests = new ArrayList<>();
        for (OrderRequest request : orderRequestList) {
            if (request.getProductId().equals(productId)) {
                requests.add(request);
            }
        }
        return requests;
    }

    // 기타 CRUD 메서드
}
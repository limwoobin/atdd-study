package com.example.atdd.application;

import com.example.atdd.domain.PendingOrder;
import com.example.atdd.domain.PendingOrderRepository;
import com.example.atdd.infra.PendingOrderRepositoryMemoryImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateOrderServiceTest {
    private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();
    private CreateOrderService createOrderService = new CreateOrderServiceImpl(pendingOrderRepository);

    @Test
    void createPendingOrder() {
        Long productId = 1L;
        Long quantity = 2L;
        PendingOrderRequest request = PendingOrderRequest.of(productId , quantity);

        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
        assertThat(pendingOrder.getId()).isPositive();
    }

}

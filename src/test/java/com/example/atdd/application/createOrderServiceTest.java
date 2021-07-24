package com.example.atdd.application;

import com.example.atdd.domain.PendingOrder;
import com.example.atdd.domain.PendingOrderRepository;
import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;

public class createOrderServiceTest {
    private CreateOrderService createOrderService = new CreateOrderServiceImpl();

    @Test
    void createPendingOrder() {
        Long productId = 1L;
        Long quantity = 2L;
        PendingOrderRequest request = PendingOrderRequest.of(productId , quantity);

        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
        assertThat(pendingOrder.getId()).isPositive();
    }

    private static class CreateOrderServiceImpl implements CreateOrderService {
        private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();

        @Override
        public PendingOrder createPendingOrder(PendingOrderRequest request) {
            PendingOrder pendingOrder = new PendingOrder(request.getProductId() , request.getQuantity());
            pendingOrder = pendingOrderRepository.save(pendingOrder);
            return pendingOrder;
        }
    }

    private static class PendingOrderRepositoryMemoryImpl implements PendingOrderRepository {
        private final AtomicLong atomicId = new AtomicLong(1);

        @Override
        public PendingOrder save(PendingOrder pendingOrder) {
            pendingOrder.assignId(nextId());
            return pendingOrder;
        }

        private long nextId() {
            return atomicId.getAndIncrement();
        }
    }
}

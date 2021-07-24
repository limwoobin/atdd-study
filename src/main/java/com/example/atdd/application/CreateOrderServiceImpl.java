package com.example.atdd.application;

import com.example.atdd.domain.PendingOrder;
import com.example.atdd.domain.PendingOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderServiceImpl implements CreateOrderService {
    private final PendingOrderRepository pendingOrderRepository;

    public CreateOrderServiceImpl(PendingOrderRepository pendingOrderRepository) {
        this.pendingOrderRepository = pendingOrderRepository;
    }

    @Override
    public PendingOrder createPendingOrder(PendingOrderRequest request) {
        PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
        pendingOrder = pendingOrderRepository.save(pendingOrder);
        return pendingOrder;
    }
}

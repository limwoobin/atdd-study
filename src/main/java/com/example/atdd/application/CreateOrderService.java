package com.example.atdd.application;

import com.example.atdd.domain.PendingOrder;

public interface CreateOrderService {
    PendingOrder createPendingOrder(PendingOrderRequest request);
}

package com.example.atdd.application;

import com.example.atdd.domain.PendingOrder;
import lombok.Getter;

@Getter
public class PendingOrderResponse {
    private long id;
    private long productId;
    private long quantity;

    public PendingOrderResponse(long productId, long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public PendingOrderResponse(PendingOrder pendingOrder) {
        this.id = pendingOrder.getId();
        this.productId = pendingOrder.getProductId();
        this.quantity = pendingOrder.getQuantity();
    }
}

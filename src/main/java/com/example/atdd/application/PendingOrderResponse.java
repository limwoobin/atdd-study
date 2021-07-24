package com.example.atdd.application;

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
}

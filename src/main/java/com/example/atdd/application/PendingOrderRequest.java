package com.example.atdd.application;

import lombok.Getter;

@Getter
public class PendingOrderRequest {
    private long productId;
    private long quantity;

    public PendingOrderRequest(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public static PendingOrderRequest of(Long productId, Long quantity) {
        return new PendingOrderRequest(productId , quantity);
    }
}

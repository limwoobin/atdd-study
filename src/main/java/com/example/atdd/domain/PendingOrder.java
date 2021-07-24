package com.example.atdd.domain;

import lombok.Getter;

@Getter
public class PendingOrder {
    private long id;
    private long productId;
    private long quantity;

    public PendingOrder(long productId, long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public void assignId(long nextId) {
        this.id = nextId;
    }
}

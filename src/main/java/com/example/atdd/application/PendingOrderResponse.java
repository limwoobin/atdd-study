package com.example.atdd.application;

import lombok.Getter;

@Getter
public class PendingOrderResponse {
    private long id;
    private long productId;
    private int quantity;
}

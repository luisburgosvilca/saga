package com.axon.requests;

import lombok.Data;

@Data
public class CreateOrderRequest {

    String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public CreateOrderRequest(){}

    public CreateOrderRequest(String orderId) {
        this.orderId = orderId;
    }
}

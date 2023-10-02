package com.axon.events;

public class CreateOrderEvent {

    private final String orderId;

    public CreateOrderEvent(String orderId){
        this.orderId = orderId;
    }

    public String getOrderId(){
        return  orderId;
    }

}

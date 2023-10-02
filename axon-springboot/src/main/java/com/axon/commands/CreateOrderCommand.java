package com.axon.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private final String orderId;

    public CreateOrderCommand(String orderId){
        this.orderId = orderId;
    }

    public String getOrderId(){
        return orderId;
    }

}

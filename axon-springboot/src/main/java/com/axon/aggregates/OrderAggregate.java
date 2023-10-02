package com.axon.aggregates;

import com.axon.commands.CreateOrderCommand;
import com.axon.events.CreateOrderEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;

    protected OrderAggregate(){}

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command){
        AggregateLifecycle.apply(new CreateOrderEvent(command.getOrderId()));
    }

    @EventSourcingHandler
    public void on(CreateOrderEvent event){
        this.orderId = event.getOrderId();
    }

}

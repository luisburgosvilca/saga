package com.dailycodebuffer.OrderService.ShipmentService.command.api.aggregate;

import com.dailycodebuffer.OrderService.CommonService.commands.ShipOrderCommand;
import com.dailycodebuffer.OrderService.CommonService.events.OrderShippedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ShipmentAggregate {

    @AggregateIdentifier
    private String shipmentId;
    private String orderId;
    private String shipmentStatus;

    public ShipmentAggregate() {
    }

    @CommandHandler
    public ShipmentAggregate(ShipOrderCommand shipOrderCommand) {
        //validate the Command
        //Publish The Order Shipped event

        OrderShippedEvent orderShipmentEvent
                = OrderShippedEvent
                .builder()
                .shipmentId(shipOrderCommand.getShipmentId())
                .shipmentId("COMPLETED")
                .build();

        AggregateLifecycle.apply(orderShipmentEvent);
    }

    @EventSourcingHandler
    public void on(OrderShippedEvent event){
        this.orderId        = event.getOrderId();
        this.shipmentId     = event.getShipmentId();
        this.shipmentStatus = event.getShipmentStatus();
    }

}

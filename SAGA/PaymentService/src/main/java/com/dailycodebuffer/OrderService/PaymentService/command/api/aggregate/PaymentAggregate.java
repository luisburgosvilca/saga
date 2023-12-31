package com.dailycodebuffer.OrderService.PaymentService.command.api.aggregate;

import com.dailycodebuffer.OrderService.CommonService.commands.ValidatePaymentCommand;
import com.dailycodebuffer.OrderService.CommonService.events.PaymentProcessedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class PaymentAggregate {

    private String paymentId;
    private String orderId;
    private String paymentStatus;

    public PaymentAggregate() {
    }

    @CommandHandler
    public PaymentAggregate(ValidatePaymentCommand validatePaymentCommand) {
        //Validate the Payment Details
        //Publish the Payment Processed event
        log.info("Executing ValidatePaymentCommand for" +
                "Order Id: {} and Payment Id: {}",
                validatePaymentCommand.getOrderId(),
                validatePaymentCommand.getPaymentId());

        PaymentProcessedEvent paymentProcessedEvent
                = new PaymentProcessedEvent(
                        validatePaymentCommand.getPaymentId(), validatePaymentCommand.getOrderId()
                );

        AggregateLifecycle.apply(paymentProcessedEvent);

        log.info("PaymentProcessedEvent Applied");
    }

    public void on(PaymentProcessedEvent event){
        this.paymentId = event.getPaymentId();
        this.orderId = event.getOrderId();
    }

}

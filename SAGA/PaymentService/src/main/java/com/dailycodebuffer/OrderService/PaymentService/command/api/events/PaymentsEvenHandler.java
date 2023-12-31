package com.dailycodebuffer.OrderService.PaymentService.command.api.events;

import com.dailycodebuffer.OrderService.CommonService.events.PaymentProcessedEvent;
import com.dailycodebuffer.OrderService.PaymentService.command.api.data.Payment;
import com.dailycodebuffer.OrderService.PaymentService.command.api.data.PaymentRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PaymentsEvenHandler {

    private PaymentRepository paymentRepository;

    public PaymentsEvenHandler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @EventHandler
    public void on(PaymentProcessedEvent event){

        Payment payment
                = Payment.builder()
                .paymentId(event.getPaymentId())
                .orderId(event.getOrderId())
                .paymentStatus("COMPLETED")
                .timeStamp(new Date())
                .build();

        paymentRepository.save(payment);
    }

}

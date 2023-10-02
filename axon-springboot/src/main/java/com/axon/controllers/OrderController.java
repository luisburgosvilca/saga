package com.axon.controllers;

import com.axon.commands.CreateOrderCommand;
import com.axon.requests.CreateOrderRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final CommandGateway commandGateway;

    public OrderController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderRequest request){
        String orderId = UUID.randomUUID().toString();
        commandGateway.send(new CreateOrderCommand(orderId));
        return ResponseEntity.accepted().body(orderId);
    }

}

package com.dailycodebuffer.OrderService.command.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRestModel {
    private String productId;
    private String userId;
    private String addressId;
    private String quantity;
}

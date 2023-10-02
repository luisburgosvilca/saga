package com.dailycodebuffer.OrderService.UserService.projection;

import com.dailycodebuffer.OrderService.CommonService.model.CardDetails;
import com.dailycodebuffer.OrderService.CommonService.model.User;
import com.dailycodebuffer.OrderService.CommonService.queries.GetUserPaymentDetailsQuery;
import org.springframework.stereotype.Component;

@Component
public class UserProjection {

    public User getUserPaymentDetails(GetUserPaymentDetailsQuery query){

        //Ideally Get the details from the DB
        CardDetails cardDetails
                = CardDetails.builder()
                .name("Shabbir Dawoodi")
                .validUntilYear(2022)
                .validUntilMonth(01)
                .cardNumber("123456789")
                .cvv(111)
                .build();

        return User.builder()
                .userId(query.getUserId())
                .firstName("Shabbir")
                .lastName("Dawoodi")
                .cardDetails(cardDetails)
                .build();
    }

}

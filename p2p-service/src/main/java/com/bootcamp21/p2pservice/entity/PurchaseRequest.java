package com.bootcamp21.p2pservice.entity;

import com.bootcamp21.p2pservice.entity.enums.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("purchaseRequests")
public class PurchaseRequest {

    private String id;
    private float amount;
    private PaymentMethod paymentMethod;
}

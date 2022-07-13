package com.bootcamp21.p2pservice.entity;

import com.bootcamp21.p2pservice.entity.enums.PaymentMethod;
import com.bootcamp21.p2pservice.entity.enums.TransactionStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document("transactions")
public class Transaction {

    @Id
    private String id;
    private String buyerWalletId;
    private String sellerWalletId;
    private float bootcoinAmount;
    private PaymentMethod paymentMethod;
    private String paymentMethodNumber;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private TransactionStatus status = TransactionStatus.LOOKING_FOR_SELLER;
}

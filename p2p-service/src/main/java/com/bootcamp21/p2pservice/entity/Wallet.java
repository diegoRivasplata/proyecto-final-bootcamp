package com.bootcamp21.p2pservice.entity;

import com.bootcamp21.p2pservice.entity.enums.DocumentType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("wallet")
public class Wallet {
    @Id
    private String id;
    private String clientName;
    private DocumentType documentType;
    private String documentNumber;
    private String phoneNumber;
    private String email;
    private float bootcoinBalance = 0;
    private float solesBalance = 0;
    private boolean isActive = true;
}

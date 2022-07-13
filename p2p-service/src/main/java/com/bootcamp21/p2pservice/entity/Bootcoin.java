package com.bootcamp21.p2pservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document("bootcoin")
public class Bootcoin {
    @Id
    private String id;
    private float buyPrice;
    private float sellPrice;
    private LocalDateTime updateTime = LocalDateTime.now();
}

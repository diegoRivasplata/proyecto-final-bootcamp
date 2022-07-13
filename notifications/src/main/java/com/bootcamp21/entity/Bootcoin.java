package com.bootcamp21.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Bootcoin {
    private String id;
    private float buyPrice;
    private float sellPrice;
    private LocalDateTime updateTime = LocalDateTime.now();
}

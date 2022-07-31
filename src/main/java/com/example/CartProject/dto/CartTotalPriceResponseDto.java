package com.example.CartProject.dto;

import lombok.Data;

@Data
public class CartTotalPriceResponseDto {

    public Long userId;
    public Integer totalPrice;
    public String transactionId;
}

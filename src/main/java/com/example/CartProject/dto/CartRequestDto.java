package com.example.CartProject.dto;

import com.example.CartProject.Entity.BaseModel;
import lombok.Data;

@Data
public class CartRequestDto {

    public Long userId;
    public Long productId;
    public Integer quantity;

}

package com.example.CartProject.service;

import com.example.CartProject.Entity.Cart;
import com.example.CartProject.dto.CartRequestDto;
import com.example.CartProject.dto.CartTotalPriceResponseDto;

import java.util.List;

public interface CartService {
    void addSelectProductToCart(CartRequestDto param);

    List<Cart> getAllProductsInCart(Long userId);

    CartTotalPriceResponseDto getFinalTotalPrice(Long userId);

    void deleteProductInCart(Long id);

    public Cart cart();
}

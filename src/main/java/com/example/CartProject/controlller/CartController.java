package com.example.CartProject.controlller;


import com.example.CartProject.Entity.Cart;
import com.example.CartProject.common.BaseResponse;
import com.example.CartProject.common.CommonCode;
import com.example.CartProject.common.CommonMessage;
import com.example.CartProject.dto.CartRequestDto;
import com.example.CartProject.dto.CartTotalPriceResponseDto;
import com.example.CartProject.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    public CartServiceImpl cartService;

    @PostMapping(value = "/addProductToCart")
    public BaseResponse<CartRequestDto> addProductToItem(@RequestBody CartRequestDto param){
        try {
            if (Objects.nonNull(param)){
                cartService.addSelectProductToCart(param);
                return new BaseResponse(CommonMessage.SAVED,CommonCode.SUCCESS);
            } else {
                return null;
            }
        } catch (Exception e){
            return new BaseResponse(CommonMessage.NOT_SAVED, CommonCode.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/getAllProductsInCart/{userid}")
    public BaseResponse getAllProductsInCart(@PathVariable ("userid") Long userId){
        try{
            List<Cart> allProductsInCart = cartService.getAllProductsInCart(userId);
            return new  BaseResponse(CommonMessage.FOUND,CommonCode.SUCCESS,allProductsInCart);
        } catch (Exception e){
            return new BaseResponse(CommonMessage.NOT_FOUND,CommonCode.NOT_FOUND);
        }
    }

    @GetMapping(value = "/finalizeTotalPrice/{userid}")
    public BaseResponse finalizeTotalPrice(@PathVariable("userid") Long userId){
        try{
            CartTotalPriceResponseDto getfinalTotalPrize = cartService.getFinalTotalPrice(userId);
            return new BaseResponse(CommonMessage.SAVED,CommonCode.SUCCESS,getfinalTotalPrize);
        } catch (Exception e){
            return new BaseResponse(CommonMessage.NOT_SAVED,CommonCode.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/deleteProductInCart/{userid}")
    public BaseResponse deleteProductinCart(@PathVariable("id") Long id){
        cartService.deleteProductInCart(id);
        return new BaseResponse(CommonMessage.SAVED,CommonCode.SUCCESS);
    }






}

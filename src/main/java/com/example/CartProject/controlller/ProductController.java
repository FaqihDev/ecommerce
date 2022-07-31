package com.example.CartProject.controlller;


import com.example.CartProject.common.BaseResponse;
import com.example.CartProject.common.CommonCode;
import com.example.CartProject.common.CommonMessage;
import com.example.CartProject.Entity.Product;
import com.example.CartProject.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProductServiceImpl productService;


    @GetMapping("/getAllProducts")
    public BaseResponse getAllProducts(@RequestBody Product param){
        List<Product> listProduct = productService.getAll();
        return new BaseResponse(CommonMessage.FOUND,CommonCode.SUCCESS,listProduct);
    }

    @PostMapping("/add")
    public BaseResponse<Product> addNewProducts(@RequestBody Product param){
        productService.saveNewProduct(param);
        return new BaseResponse(CommonMessage.SAVED, CommonCode.SUCCESS);
    }

    @GetMapping("/getProductById/{id}")
    public BaseResponse<Product> getProductById(Long id){
        productService.getProductById(id);
        return new BaseResponse(CommonMessage.FOUND,CommonCode.SUCCESS);
    }

}

package com.example.CartProject.service.impl;


import com.example.CartProject.Entity.Product;
import com.example.CartProject.Repository.ProductRepository;
import com.example.CartProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }


    @Override
    public void saveNewProduct(Product param) {
        param.setCreatedBy("Admin");
        param.setIsDeleted(0);
        java.util.Date today = Date.from(Instant.now());
        param.setCreatedDate(String.valueOf(today));
        productRepository.save(param);
    }

    @Override
    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

}

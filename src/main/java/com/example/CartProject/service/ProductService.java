package com.example.CartProject.service;

import com.example.CartProject.Entity.Product;

import java.util.List;

public interface ProductService {




    void saveNewProduct(Product param);

    List<Product> getAll();

    Product getProductById(Long id);
}

package com.example.CartProject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class ProductDtoRequest {

    private String name;
    private String brand;
    private Integer quantity;
    private String code;
    private Double price;
    private String image;
    private Date expDate;


}

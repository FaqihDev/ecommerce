package com.example.CartProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Entity
public class Product extends BaseModel {

    @Column(name = "product_name",nullable = false)
    private String name;

    @Column(name = "product_brand",nullable = false)
    private String brand;

    @Column(name = "product_quantity",nullable = false)
    private Integer quantity;

    @Column(name = "product_code",nullable = false)
    private String code;

    @Column (name = "product_price",nullable = false)
    private Integer price;

    @Column(name = "product_exp_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exDate;

}



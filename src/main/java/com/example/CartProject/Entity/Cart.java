package com.example.CartProject.Entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cart")
public class Cart extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Product productId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private User userId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "is_cancel")
    private Integer isCancel;
}

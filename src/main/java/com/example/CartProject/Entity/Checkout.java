package com.example.CartProject.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "checkout")
@Entity
public class Checkout extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "transaction_id")
    private String transactionId;

}

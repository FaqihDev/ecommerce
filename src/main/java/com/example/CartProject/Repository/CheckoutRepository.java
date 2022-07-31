package com.example.CartProject.Repository;

import com.example.CartProject.Entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout,Long> {
}

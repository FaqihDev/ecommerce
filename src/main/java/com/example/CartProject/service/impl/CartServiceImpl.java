package com.example.CartProject.service.impl;


import com.example.CartProject.Entity.Cart;
import com.example.CartProject.Entity.Checkout;
import com.example.CartProject.Entity.Product;
import com.example.CartProject.Entity.User;
import com.example.CartProject.Repository.CartRepository;
import com.example.CartProject.Repository.CheckoutRepository;
import com.example.CartProject.Repository.ProductRepository;
import com.example.CartProject.Repository.UserRepository;
import com.example.CartProject.dto.CartRequestDto;
import com.example.CartProject.dto.CartTotalPriceResponseDto;
import com.example.CartProject.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {


    public  final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CheckoutRepository checkoutRepository;




    @Override
    public void addSelectProductToCart(CartRequestDto param){

        Cart cart = new Cart();

        //Ngecheck apakah tipe data yang ada di user ini sama dengan data yang akan di request
        User user = userRepository.findById(param.getUserId()).orElse(null);
        cart.setUserId(user);
        //Inject Product ke Product Dto
        Product product = productRepository.findById(param.getProductId()).orElse(null);
        cart.setProductId(product);
        assert product != null;

        cart.setAmount(product.getPrice());
        cart.setTotalPrice(product.getPrice() * param.getQuantity() );
        cart.setIsCancel(0);
        cartRepository.save(cart);

    }

    @Override
     public List<Cart> getAllProductsInCart(Long userId){
        //Mencari user dengan id sekaligus ngecheck apakah user req ada di database
        User user = userRepository.findById(userId).orElse(null);
        //Membuat variabel baru berbentuk list dari class Cart dan ambil semuanya berdasarkan user id
        List<Cart> allByUserId = cartRepository.findAllByUserId(user);
        //cetak variabel list cart
        System.out.println("allByUserId = " + allByUserId);
        return allByUserId;
     }

     @Override
     public CartTotalPriceResponseDto getFinalTotalPrice(Long userId){

        //Ambil semua product di cart dengan megambil method yang sudah ada di atas dan ditampung di variable baru
        List<Cart> allProductInCart = this.getAllProductsInCart(userId);

        //buat variable untuk price
        int totalPrice = 0;

        //looping semua product di cart dan jumlah harganya
        for (Cart cart : allProductInCart) {
            totalPrice = totalPrice + cart.getTotalPrice();
        }

        //Buat object dtoresponse dan set request to response
        CartTotalPriceResponseDto c = new CartTotalPriceResponseDto();
        c.setUserId(userId);
        c.setTotalPrice(totalPrice);
        c.setTransactionId(UUID.randomUUID().toString());

        //Buat objek check out dan
        Checkout checkout = new Checkout();
        //Cari user dengan id tertentu
        User user = userRepository.findById(userId).orElse(null);
        checkout.setUserId(user);
        checkout.setTotalPrice(totalPrice);
        checkout.setTransactionId(UUID.randomUUID().toString());

        checkoutRepository.save(checkout);
        return c;

     }

     @Override
     public void deleteProductInCart(Long id){
        cartRepository.deleteById(id);
     }


}

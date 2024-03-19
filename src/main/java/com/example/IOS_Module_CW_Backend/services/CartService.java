package com.example.IOS_Module_CW_Backend.services;

import com.example.IOS_Module_CW_Backend.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {

    List<Cart> fetchAllCartDetails();

    Optional<Cart> findByCustomerName(String customerName);

    Cart addCart(Cart cart);

    Cart updateCartById(Cart cart);

    String deleteCartById(Long cartId);
}

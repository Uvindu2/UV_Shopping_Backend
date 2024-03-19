package com.example.IOS_Module_CW_Backend.services.impl;

import com.example.IOS_Module_CW_Backend.model.Cart;
import com.example.IOS_Module_CW_Backend.model.Customer;
import com.example.IOS_Module_CW_Backend.repository.CartRepository;
import com.example.IOS_Module_CW_Backend.repository.CustomerRepository;
import com.example.IOS_Module_CW_Backend.services.CartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;

    public CartServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Cart> fetchAllCartDetails() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findByCustomerName(String customerName) {
        Optional<Customer> customer = customerRepository.findCustomerByName(customerName);
        return cartRepository.findById(customer.get().getId());
    }

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCartById(Cart cart) {
        if (cartRepository.existsById(cart.getId())) {
            return cartRepository.save(cart);
        } else {
            System.out.println("Cart id is not available this id: " + cart.getId());
        }

        return cart;
    }

    @Override
    public String deleteCartById(Long cartId) {
        if (cartRepository.existsById(cartId)) {
            cartRepository.deleteById(cartId);
            return "Cart with ID " + cartId + " deleted Successfully";
        } else {
            return "Cart is is not found.";
        }

    }


}

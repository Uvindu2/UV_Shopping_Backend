package com.example.IOS_Module_CW_Backend.Controller;

import com.example.IOS_Module_CW_Backend.model.Cart;
import com.example.IOS_Module_CW_Backend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/all")
    public List<Cart> findAllCart() {
        return cartService.fetchAllCartDetails();
    }

    @GetMapping("/findByUserName/{username}")
    public List<Cart> findCartByCustomerName(@PathVariable String username) {
        return cartService.findCartByCustomerName(username);
    }

    @PostMapping("/add")
    public Cart addAllCart(@RequestBody Cart cart) {
        return cartService.addCart(cart);
    }

    @PutMapping("/update")
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCartById(cart);
    }

    @DeleteMapping("/delete/{cartId}")
    public String deleteCartById(@PathVariable Long cartId) {
        return cartService.deleteCartById(cartId);
    }


}

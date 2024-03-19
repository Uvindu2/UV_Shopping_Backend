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
    public List<Cart> findAllProducts() {
        return cartService.fetchAllCartDetails();
    }

    @GetMapping("/findByCusName/{customerName}")
    public Optional<Cart> findByCustomerName(@PathVariable String customerName) {
        return cartService.findByCustomerName(customerName);
    }

    @PostMapping("/add")
    public Cart addAllCart(@RequestBody Cart cart) {
        return cartService.addCart(cart);
    }

    @PutMapping("/update")
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCartById(cart);
    }

    @DeleteMapping("/delete")
    public String deleteCart(@RequestBody Long cartId) {
        return cartService.deleteCartById(cartId);
    }


}

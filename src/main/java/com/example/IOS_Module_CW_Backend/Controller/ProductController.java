package com.example.IOS_Module_CW_Backend.Controller;

import com.example.IOS_Module_CW_Backend.model.Customer;
import com.example.IOS_Module_CW_Backend.model.Product;
import com.example.IOS_Module_CW_Backend.model.dto.ProductDTO;
import com.example.IOS_Module_CW_Backend.services.CartService;
import com.example.IOS_Module_CW_Backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<ProductDTO> findAllProducts() {
        return productService.fetchAllProducts();
    }

    @PostMapping("/add")
    public Product addAllProducts(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}

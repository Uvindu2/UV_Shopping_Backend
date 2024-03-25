package com.example.IOS_Module_CW_Backend.Controller;

import com.example.IOS_Module_CW_Backend.model.Customer;
import com.example.IOS_Module_CW_Backend.model.Product;
import com.example.IOS_Module_CW_Backend.model.dto.ProductDTO;
import com.example.IOS_Module_CW_Backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> findAllProducts() {
        return productService.fetchAllProducts();
    }

    @GetMapping("/findProductById")
    public Optional<Product> findProductById(Long productId) {
        return productService.findProductById(productId);
    }

    @PostMapping("/add")
    public Product addAllProducts(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/update")
    public Product updateProductById(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/fetchAllByProductCategory/{product_category}")
    public List<Product> fetchByProductCategory(@PathVariable String product_category) {
        return productService.fetchByProductCategory(product_category);
    }

    @GetMapping("/fetchAllByProductPrice{start_Price}/{end_price}")
    public List<Product> fetchAllByProductPrice(@PathVariable Double start_Price,Double end_price) {
        return productService.fetchAllByProductPrice(start_Price,end_price);
    }
}

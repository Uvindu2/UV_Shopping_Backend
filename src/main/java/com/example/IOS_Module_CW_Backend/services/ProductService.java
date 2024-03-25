package com.example.IOS_Module_CW_Backend.services;

import com.example.IOS_Module_CW_Backend.model.Product;
import com.example.IOS_Module_CW_Backend.model.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> fetchAllProducts();

    Optional<Product> findProductById(Long productId);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    List<Product> fetchByProductCategory(String product_category);

    List<Product> fetchAllByProductPrice(Double start_price, Double end_price);

}

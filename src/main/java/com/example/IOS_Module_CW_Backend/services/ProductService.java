package com.example.IOS_Module_CW_Backend.services;

import com.example.IOS_Module_CW_Backend.model.Product;
import com.example.IOS_Module_CW_Backend.model.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> fetchAllProducts();

    Optional<Product> findByProductId(Long productId);

    Product addProduct(Product product);


}

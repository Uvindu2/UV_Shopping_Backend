package com.example.IOS_Module_CW_Backend.services.impl;

import com.example.IOS_Module_CW_Backend.model.Image;
import com.example.IOS_Module_CW_Backend.model.Product;
import com.example.IOS_Module_CW_Backend.model.dto.ImageDTO;
import com.example.IOS_Module_CW_Backend.model.dto.ProductDTO;
import com.example.IOS_Module_CW_Backend.repository.ImageRepository;
import com.example.IOS_Module_CW_Backend.repository.ProductRepository;
import com.example.IOS_Module_CW_Backend.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    public ProductServiceImpl(ProductRepository productRepository, ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    //under function replace by your own
    @Override
    public List<Product> fetchAllProducts() {
         return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        if (productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        } else {
            System.out.println("Customer id is not available this id: " + product.getId());
        }
        return product;
    }

    @Override
    public List<Product> fetchByProductCategory(String product_category) {
        return productRepository.findProductsByCategory(product_category);
    }

    @Override
    public List<Product> fetchAllByProductPrice(Double start_price, Double end_price) {
        return productRepository.findByPriceBetween(start_price,end_price);
    }
}

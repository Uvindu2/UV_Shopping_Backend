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
    public List<ProductDTO> fetchAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : productList) {
            Long productId = product.getId();
            String productName = product.getName();
            String productDescription = product.getDescription();
            String productSize = product.getSize();
            Double productPrice = product.getPrice();
            String productColour = product.getColor();

            List<Image> images = imageRepository.findAllByProductId(productId);
            List<ImageDTO> imageDTOList = new ArrayList<>();
            for (Image image : images) {
                Long imageId = image.getId();
                String imageUrl = image.getUrl();
                imageDTOList.add(new ImageDTO(imageId, imageUrl));
            }
            productDTOList.add(new ProductDTO(productId, productName, productDescription, productSize, productPrice, productColour, imageDTOList));
        }
        return productDTOList;
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

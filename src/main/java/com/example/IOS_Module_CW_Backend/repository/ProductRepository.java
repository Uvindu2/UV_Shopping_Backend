package com.example.IOS_Module_CW_Backend.repository;

import com.example.IOS_Module_CW_Backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByCategory(String productCategory);

    List<Product> findByPriceBetween(Double start_price,Double end_price);
}

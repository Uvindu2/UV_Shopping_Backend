package com.example.IOS_Module_CW_Backend.repository;

import com.example.IOS_Module_CW_Backend.model.Customer;
import com.example.IOS_Module_CW_Backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByProductId(Long productId);
}

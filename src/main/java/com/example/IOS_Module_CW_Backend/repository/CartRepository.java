package com.example.IOS_Module_CW_Backend.repository;

import com.example.IOS_Module_CW_Backend.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}

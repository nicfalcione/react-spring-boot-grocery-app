package com.example.demo.repository;

import com.example.demo.model.GroceryListItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends JpaRepository<GroceryListItem, Long> {
    
}

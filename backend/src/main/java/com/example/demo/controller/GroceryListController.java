package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.GroceryListItem;
import com.example.demo.repository.GroceryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/")
public class GroceryListController {
    
    @Autowired
    private GroceryRepository groceryRepository;

    @GetMapping("/items")
    public List<GroceryListItem> getAllGroceries() {
        return groceryRepository.findAll();
    }

    @PostMapping("/items")
    public GroceryListItem createGroceryListItem(@RequestBody GroceryListItem groceryListItem) {
        return groceryRepository.save(groceryListItem);
    }

    @PostMapping("/items/{id}")
    public GroceryListItem addGroceryListItem(@RequestBody GroceryListItem groceryListItem, @PathVariable Long id) {
        return groceryRepository.save(groceryListItem);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<GroceryListItem> getGroceryListItemById(@PathVariable Long id) {
        GroceryListItem groceryListItem = groceryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(""));

        return ResponseEntity.ok(groceryListItem);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<GroceryListItem> checkOffGroceryItem(@PathVariable Long id) {
        GroceryListItem groceryListItem = groceryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(""));
            
        groceryListItem.setChecked(!groceryListItem.getChecked());

        GroceryListItem updatedGroceryListItem = groceryRepository.save(groceryListItem);
        return ResponseEntity.ok(updatedGroceryListItem);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteGroceryItem(@PathVariable Long id) {
        GroceryListItem groceryListItem = groceryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(""));
            
        groceryRepository.delete(groceryListItem);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

package com.thibaut.catservice.web;

import com.thibaut.catservice.dao.ProductRepository;
import com.thibaut.catservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/productsList")
    public List<Product> ProductsList(){
        return productRepository.findAll();
    }

    @GetMapping(value =  "productsList/{id}")
    public Product product(@PathVariable(name = "id") Long id){
        return productRepository.findById(id).get();
    }

    @PutMapping(value = "productsList/{id}")
    public Product updateproduct(@PathVariable(name = "id") Long id, @RequestBody Product p){
        p.setId(id);
        return productRepository.save(p);
    }
}

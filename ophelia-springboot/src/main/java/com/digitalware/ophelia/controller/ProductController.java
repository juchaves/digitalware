/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalware.ophelia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.digitalware.ophelia.model.Product;
import com.digitalware.ophelia.service.ProductService;

import java.util.List;

/**
 *
 * @author jmcp1
 */
@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(service.save(product), HttpStatus.CREATED );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product productFound = service.findById(id);
        if(productFound== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            product.setId(id);
            return new ResponseEntity<>(service.save(product), HttpStatus.CREATED);
        } catch(DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

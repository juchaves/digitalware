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

import com.digitalware.ophelia.model.Customer;
import com.digitalware.ophelia.service.CustomerService;

import java.util.List;

/**
 *
 * @author jmcp1
 */
@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;
    
    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(service.save(customer), HttpStatus.CREATED );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer customerFound = service.findById(id);
        if(customerFound== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            customer.setId(id);
            return new ResponseEntity<>(service.save(customer), HttpStatus.CREATED);
        } catch(DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

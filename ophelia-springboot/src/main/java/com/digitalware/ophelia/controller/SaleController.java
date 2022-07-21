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

import com.digitalware.ophelia.model.Sale;
import com.digitalware.ophelia.service.SaleService;

import java.util.List;

/**
 *
 * @author jmcp1
 */
@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired
    private SaleService service;

    @GetMapping("/list")
    public ResponseEntity<List<Sale>> getSales() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Sale> getSale(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        return new ResponseEntity<>(service.save(sale), HttpStatus.CREATED );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Sale> updateSale(@PathVariable Long id, @RequestBody Sale sale) {
        Sale saleFound = service.findById(id);
        if(saleFound== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            sale.setId(id);
            return new ResponseEntity<>(service.save(sale), HttpStatus.CREATED);
        } catch(DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

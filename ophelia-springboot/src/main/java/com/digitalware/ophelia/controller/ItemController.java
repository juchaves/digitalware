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

import com.digitalware.ophelia.model.Item;
import com.digitalware.ophelia.service.ItemService;

import java.util.List;

/**
 *
 * @author jmcp1
 */
@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService service;

    @GetMapping("/list")
    public ResponseEntity<List<Item>> getItems() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return new ResponseEntity<>(service.save(item), HttpStatus.CREATED );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item itemFound = service.findById(id);
        if(itemFound== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            item.setId(id);
            return new ResponseEntity<>(service.save(item), HttpStatus.CREATED);
        } catch(DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

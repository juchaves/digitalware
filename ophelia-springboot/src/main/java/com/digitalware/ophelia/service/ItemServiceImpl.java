/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalware.ophelia.service;

import com.digitalware.ophelia.model.Item;
import com.digitalware.ophelia.repository.ItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmcp1
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository repositorio;

    @Override
    public Item save(Item item) {
        return repositorio.save(item);
    }

    @Override
    public Item findById(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public List<Item> findAll() {
        return repositorio.findAll();
    }

    @Override
    public void delete(Long id) {
        repositorio.deleteById(id);
    }
    
}

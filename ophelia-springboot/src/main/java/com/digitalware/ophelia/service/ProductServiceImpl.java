/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalware.ophelia.service;

import com.digitalware.ophelia.model.Product;
import com.digitalware.ophelia.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmcp1
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repositorio;

    @Override
    public Product save(Product product) {
        return repositorio.save(product);
    }

    @Override
    public Product findById(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return repositorio.findAll();
    }

    @Override
    public void delete(Long id) {
        repositorio.deleteById(id);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalware.ophelia.service;

import com.digitalware.ophelia.model.Product;
import java.util.List;

/**
 *
 * @author jmcp1
 */
public interface ProductService {
    public Product save(Product product);
    public Product findById(Long id);
    public List<Product> findAll();
    public void delete(Long id);
}
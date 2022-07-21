/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalware.ophelia.repository;

import com.digitalware.ophelia.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jmcp1
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}

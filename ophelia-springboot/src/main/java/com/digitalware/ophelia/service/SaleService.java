/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalware.ophelia.service;

import com.digitalware.ophelia.model.Sale;
import java.util.List;

/**
 *
 * @author jmcp1
 */
public interface SaleService {
    public Sale save(Sale sale);
    public Sale findById(Long id);
    public List<Sale> findAll();
    public void delete(Long id);
}
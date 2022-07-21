/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalware.ophelia.service;

import com.digitalware.ophelia.model.Sale;
import com.digitalware.ophelia.repository.SaleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmcp1
 */
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRepository repositorio;

    @Override
    public Sale save(Sale sale) {
        return repositorio.save(sale);
    }

    @Override
    public Sale findById(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public List<Sale> findAll() {
        return repositorio.findAll();
    }

    @Override
    public void delete(Long id) {
        repositorio.deleteById(id);
    }
    
}

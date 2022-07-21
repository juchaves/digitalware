/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalware.ophelia.service;

import com.digitalware.ophelia.model.Customer;
import com.digitalware.ophelia.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmcp1
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repositorio;

    @Override
    public Customer save(Customer customer) {
        return repositorio.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return repositorio.findAll();
    }

    @Override
    public void delete(Long id) {
        repositorio.deleteById(id);
    }
    
}

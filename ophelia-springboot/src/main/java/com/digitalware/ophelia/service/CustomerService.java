/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalware.ophelia.service;

import com.digitalware.ophelia.model.Customer;
import java.util.List;

/**
 *
 * @author jmcp1
 */
public interface CustomerService {
    public Customer save(Customer customer);
    public Customer findById(Long id);
    public List<Customer> findAll();
    public void delete(Long id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalware.ophelia.service;

import com.digitalware.ophelia.model.Item;
import java.util.List;

/**
 *
 * @author jmcp1
 */
public interface ItemService {
    public Item save(Item item);
    public Item findById(Long id);
    public List<Item> findAll();
    public void delete(Long id);
}

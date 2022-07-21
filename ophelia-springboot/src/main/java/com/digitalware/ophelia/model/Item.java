/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalware.ophelia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jmcp1
 */
@Entity
@Table(name="items")
public class Item {

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the admissionDate
     */
    public Date getAdmissionDate() {
        return admissionDate;
    }

    /**
     * @param admissionDate the admissionDate to set
     */
    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     * @return the cost
     */
    public Float getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(Float cost) {
        this.cost = cost;
    }

    /**
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the sale
     */
    public Sale getSale() {
        return sale;
    }

    /**
     * @param sale the sale to set
     */
    public void setSale(Sale sale) {
        this.sale = sale;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date admissionDate;
    private Float cost;
    private Float price;
    private String itemCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name="product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name="sale_id")
    private Sale sale;
}

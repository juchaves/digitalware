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
@Table(name="sales")
public class Sale {

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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the grossValue
     */
    public Float getGrossValue() {
        return grossValue;
    }

    /**
     * @param grossValue the grossValue to set
     */
    public void setGrossValue(Float grossValue) {
        this.grossValue = grossValue;
    }

    /**
     * @return the discount
     */
    public Float getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    /**
     * @return the tax
     */
    public Float getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(Float tax) {
        this.tax = tax;
    }

    /**
     * @return the fullValue
     */
    public Float getFullValue() {
        return fullValue;
    }

    /**
     * @param fullValue the fullValue to set
     */
    public void setFullValue(Float fullValue) {
        this.fullValue = fullValue;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Float grossValue;
    private Float discount;
    private Float tax;
    private Float fullValue;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name="customer_id")
    private Customer customer;
}

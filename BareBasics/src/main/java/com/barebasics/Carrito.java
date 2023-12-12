/*
 * Copyright (c) 2023.
 */

package com.barebasics;

import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;

public class Carrito {
    private Date date;
    private int id;
    private HashMap<Integer, productData> products = new HashMap<Integer, productData>();
    private double cost;
    private User Client;
    private IPayable payment_mode;
    private Invoice invoice;

    public Carrito() {
    }

    public Carrito(Date date, HashMap<Integer, productData> products, User client, IPayable payment_mode) {
        this.date = date;
        this.products = products;
        Client = client;
        this.payment_mode = payment_mode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, productData> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, productData> products) {
        this.products = products;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public User getClient() {
        return Client;
    }

    public void setClient(User client) {
        Client = client;
    }

    public IPayable getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(IPayable payment_mode) {
        this.payment_mode = payment_mode;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }


}

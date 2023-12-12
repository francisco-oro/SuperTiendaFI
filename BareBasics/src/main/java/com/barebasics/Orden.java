/*
 * Copyright (c) 2023.
 */

package com.barebasics;

import java.util.Date;
import java.util.HashMap;

public class Orden {
    private Date date;
    private int id;
    private HashMap<Integer, productData> products = new HashMap<Integer, productData>();
    private double cost;
    private User user;

    public Orden(Date date, int id, HashMap<Integer, productData> products, double cost, User user) {
        this.date = date;
        this.id = id;
        this.products = products;
        this.cost = cost;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

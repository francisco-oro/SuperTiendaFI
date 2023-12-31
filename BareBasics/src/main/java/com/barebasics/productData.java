/*
 * Copyright (c) 2023.
 */

package com.barebasics;

public class productData {
    private String productId;
    private String brand;
    private String productName;
    private Category category;
    private Double price;
    private int units;

    public productData(String productId, String brand, String productName, String category, int categoryId, Double price, int units) {
        this.productId = productId;
        this.brand = brand;
        this.productName = productName;
        this.category = new Category(categoryId, category);
        this.price = price;
        this.units = units;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}

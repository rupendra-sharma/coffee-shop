/**
 * @FileName: ProductModel.java
 * @Author: Rupendra
 * @Package: com.coffee.product.models
 * @CreatedOn: 01-Apr-2023
 */
package com.coffee.product.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/*
 * Model class for product
 */
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private double price;

    private int quantity;

    // Constructors, getters, and setters

    public Product() {}

    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

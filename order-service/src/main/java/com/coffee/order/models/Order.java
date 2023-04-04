/**
 * @FileName: Order.java
 * @Author: Rupendra
 * @Package: com.coffee.order.models
 * @CreatedOn: 03-Apr-2023
 */
package com.coffee.order.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Rupendra
 *
 */
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String productId;

    private int quantity;

    public Order() {
    }

    public Order(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


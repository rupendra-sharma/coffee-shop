/**
 * @FileName: OrderNotFoundException.java
 * @Author: Rupendra
 * @Package: com.coffee.order.exceptions
 * @CreatedOn: 04-Apr-2023
 */
package com.coffee.order.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Rupendra
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message) {
        super(message);
    }
}


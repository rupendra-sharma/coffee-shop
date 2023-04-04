/**
 * @FileName: ProductNotFoundException.java
 * @Author: Rupendra
 * @Package: com.coffee.product.exceptions
 * @CreatedOn: 01-Apr-2023
 */
package com.coffee.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}


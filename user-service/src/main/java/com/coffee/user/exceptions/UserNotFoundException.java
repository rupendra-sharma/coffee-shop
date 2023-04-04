/**
 * @FileName: UserNotFoundException.java
 * @Author: Rupendra
 * @Package: com.coffee.user.exceptions
 * @CreatedOn: 02-Apr-2023
 */
package com.coffee.user.exceptions;

/**
 * @author Rupendra
 *
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}


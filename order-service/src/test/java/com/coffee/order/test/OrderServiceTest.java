/**
 * @FileName: OrderServiceTest.java
 * @Author: Rupendra
 * @Package: com.coffee.user.test
 * @CreatedOn: 02-Apr-2023
 */
package com.coffee.order.test;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.coffee.order.models.Order;
import com.coffee.order.repositories.OrderRepository;
import com.coffee.order.services.OrderService;

/**
 * @author Rupendra
 *
 */
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

   
 
}


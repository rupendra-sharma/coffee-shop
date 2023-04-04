/**
 * @FileName: OrderRepository.java
 * @Author: Rupendra
 * @Package: com.coffee.order.repositories
 * @CreatedOn: 04-Apr-2023
 */
package com.coffee.order.repositories;

import com.coffee.order.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Rupendra
 *
 */
public interface OrderRepository extends MongoRepository<Order, String> {
}


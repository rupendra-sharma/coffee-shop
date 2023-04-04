/**
 * @author: Rupendra
 * @Purpose: 
 * @CreateOn: 03-Apr-2023
 * @Package: com.coffee.order
 */
package com.coffee.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.coffee.order.repositories.OrderRepository;


/**
 * @author Rupendra
 *
 */
@SpringBootApplication
@EnableMongoRepositories
public class OrderServiceApplication {
	
	@Autowired
	OrderRepository orderRepo;

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}

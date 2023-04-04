/**
 * @author: Rupendra
 * @Purpose: 
 * @CreateOn: 01-Apr-2023
 * @Package: com.sma.product
 */
package com.coffee.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.coffee.product.repositories.ProductRepository;


/*
 * 
 */
@SpringBootApplication
@EnableMongoRepositories
public class ProductServiceApplication {
	
	@Autowired
	ProductRepository groceryItemRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}

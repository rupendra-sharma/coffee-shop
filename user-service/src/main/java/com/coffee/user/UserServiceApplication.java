/**
 * @author: Rupendra
 * @Purpose: 
 * @CreateOn: 01-Apr-2023
 * @Package: com.coffee.user
 */
package com.coffee.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.coffee.user.repositories.UserRepository;


/**
 * @author Rupendra
 *
 */
@SpringBootApplication
@EnableMongoRepositories
public class UserServiceApplication {
	
	@Autowired
	UserRepository groceryItemRepo;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}

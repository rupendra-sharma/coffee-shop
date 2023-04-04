/**
 * @FileName: ProductRepository.java
 * @Author: Rupendra
 * @Package: com.coffee.product.repositories
 * @CreatedOn: 01-Apr-2023
 */
package com.coffee.product.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.stereotype.Repository;
import com.coffee.product.models.Product;


/*
 * 
 */
//@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	
	@Query("{name:'?0'}")
    Product findItemByName(String name);
    
    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Product> findAll(String category);
    
    public long count();
}

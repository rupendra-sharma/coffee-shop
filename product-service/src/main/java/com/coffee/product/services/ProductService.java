/**
 * @FileName: ProductService.java
 * @Author: Rupendra
 * @Package: com.coffee.product.services
 * @CreatedOn: 03-Apr-2023
 */
package com.coffee.product.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coffee.product.models.Product;
import com.coffee.product.repositories.ProductRepository;

/*
 * Service class for managing Product objects.
 */
@Service
public class ProductService {
	
    @Autowired
    private ProductRepository productRepository;

    /**
     * Returns a list of all products in the database.
     * @return List of all products.
    */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    
    /**
     * Returns an Optional containing the product with the specified ID if it exists,
     * or an empty Optional if it doesn't exist.
     * @param id ID of the product to retrieve.
     * @return Optional containing the product with the specified ID.
    */
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    /**
     * Creates a new product in the database.
     * @param product Product to create.
     * @return The created product.
    */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Updates an existing product in the database.
     * @param product Product to update.
     * @return The updated product.
    */
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Deletes the product with the specified ID from the database.
     * @param id ID of the product to delete.
    */
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}



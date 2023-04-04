/**
 * @FileName: ProductController.java
 * @Author: Rupendra
 * @Package: com.coffee.product.api
 * @CreatedOn: 01-Apr-2023
 */
package com.coffee.product.api;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coffee.product.models.Product;
import com.coffee.product.services.ProductService;
import com.coffee.product.exceptions.ProductNotFoundException;


/*
 * The ProductController class handles all HTTP requests related to products.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /*
     * Test api
     */
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        
        return new ResponseEntity<>("test success", HttpStatus.OK);
    }
    
    /*
     * This API retrieves all the products from the database.
     */
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /*
     * This API retrieves a product by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
        Optional<Product> product = productService.getProductById(id);
        if (!product.isPresent()) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    /*
     * This API creates a new product.
     */
    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    /*
     * This API updates an existing product by its ID.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        Optional<Product> existingProduct = productService.getProductById(id);
        if (!existingProduct.isPresent()) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        product.setId(id);
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    /*
     * This API deletes a product by its ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") String id) {
        Optional<Product> existingProduct = productService.getProductById(id);
        if (!existingProduct.isPresent()) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
     * This method handles the ProductNotFoundException and returns a NOT_FOUND response.
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /*
     * This method handles all other exceptions and returns an INTERNAL_SERVER_ERROR response.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

/**
 * @FileName: UserController.java
 * @Author: Rupendra
 * @Package: com.coffee.user.api
 * @CreatedOn: 02-Apr-2023
 */

package com.coffee.user.api;

import com.coffee.user.exceptions.UserNotFoundException;
import com.coffee.user.models.User;
import com.coffee.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class defines the REST API endpoints for User operations.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor injection for UserService dependency.
     *
     * @param userService instance of UserService
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Test endpoint to verify if the API is up and running.
     *
     * @return ResponseEntity with "test success" message and HTTP OK status code.
     */
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("test success", HttpStatus.OK);
    }

    /**
     * Endpoint to fetch all users.
     *
     * @return List of all User objects.
     */
    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Endpoint to fetch a specific user by ID.
     *
     * @param id ID of the user to be fetched.
     * @return ResponseEntity with User object and HTTP OK status code on success.
     *         Returns HTTP NOT_FOUND status code if user is not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        try {
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint to save a new user.
     *
     * @param user User object to be saved.
     * @return Saved User object.
     */
    @PostMapping("")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * Endpoint to delete a specific user by ID.
     *
     * @param id ID of the user to be deleted.
     * @return ResponseEntity with HTTP NO_CONTENT status code on success.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

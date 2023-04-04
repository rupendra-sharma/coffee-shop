/**
 * @FileName: UserService.java
 * @Author: Rupendra
 * @Package: com.coffee.user.services
 * @CreatedOn: 02-Apr-2023
 */
package com.coffee.user.services;

import com.coffee.user.exceptions.UserNotFoundException;
import com.coffee.user.models.User;
import com.coffee.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing user data.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Returns a list of all users.
     * @return List of User objects.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Returns the User object with the given id.
     * @param id String value representing the id of the user.
     * @return User object.
     * @throws UserNotFoundException if user with the given id is not found.
     */
    public User getUserById(String id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    /**
     * Saves the given user object.
     * @param user User object to be saved.
     * @return User object after being saved.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Deletes the user object with the given id.
     * @param id String value representing the id of the user.
     */
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}

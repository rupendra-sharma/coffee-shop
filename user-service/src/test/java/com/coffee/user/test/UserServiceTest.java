/**
 * @FileName: UserServiceTest.java
 * @Author: Rupendra
 * @Package: com.coffee.user.test
 * @CreatedOn: 02-Apr-2023
 */
package com.coffee.user.test;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.coffee.user.models.User;
import com.coffee.user.repositories.UserRepository;
import com.coffee.user.services.UserService;

/**
 * @author Rupendra
 *
 */
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User("John Doe", "johndoe@example.com", "password");
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        User createdUser = userService.saveUser(user);
        Assertions.assertEquals(user, createdUser);
    }

    @Test
    void testGetUserById() {
        User user = new User("John Doe", "johndoe@example.com", "password");
        Mockito.when(userRepository.findById(Mockito.anyString())).thenReturn(Optional.of(user));
        Optional<User> retrievedUser = Optional.ofNullable(userService.getUserById("1"));
        Assertions.assertEquals(user, retrievedUser.get());
    }

 
}


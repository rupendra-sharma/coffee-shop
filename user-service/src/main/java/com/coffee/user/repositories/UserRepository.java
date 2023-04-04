/**
 * @FileName: UserRepository.java
 * @Author: Rupendra
 * @Package: com.coffee.user.repositories
 * @CreatedOn: 02-Apr-2023
 */
package com.coffee.user.repositories;

import com.coffee.user.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Rupendra
 *
 */

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}

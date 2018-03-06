package com.suirtech.bugs.repositories;

import com.suirtech.bugs.model.auth.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
//	User findByEmail(String email);

}

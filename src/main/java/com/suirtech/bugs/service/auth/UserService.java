package com.suirtech.bugs.service.auth;


import com.suirtech.bugs.model.auth.User;

public interface UserService {

	User findByEmail(String username);

}

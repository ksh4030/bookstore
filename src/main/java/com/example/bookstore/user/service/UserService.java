package com.example.bookstore.user.service;

import com.example.bookstore.user.dto.UserInput;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    boolean signup(UserInput parameter);

}

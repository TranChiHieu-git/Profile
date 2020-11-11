package com.example.demo.JWT.Services;

import com.example.demo.JWT.Modals.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void save(User user);

    Iterable<User> findAll();

    User findByUserName(String username);
}

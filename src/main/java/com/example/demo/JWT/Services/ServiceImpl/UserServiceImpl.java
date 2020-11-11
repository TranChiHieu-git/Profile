package com.example.demo.JWT.Services.ServiceImpl;

import com.example.demo.JWT.Modals.User;
import com.example.demo.JWT.Modals.UserPrinciple;
import com.example.demo.JWT.Repositorys.UserRepository;
import com.example.demo.JWT.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) {
        User user = userRepository.findByUsername(s);
        if (user == null) throw new UsernameNotFoundException(s);
        return UserPrinciple.build(user);
    }
}

package com.empyr.api.consumer.service;


import com.empyr.api.consumer.model.User;
import com.empyr.api.consumer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User Save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User foundUser = userRepository.findByEmail(user.getEmail());
        if(foundUser == null) {
            return userRepository.save(user);
        }

        return null;
    }

    public User FindByEmail(String email){
        User user = userRepository.findByEmail(email);
        return user;
    }
}

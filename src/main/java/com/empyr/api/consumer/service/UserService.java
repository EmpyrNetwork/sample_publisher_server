package com.empyr.api.consumer.service;


import com.empyr.api.consumer.model.User;

public interface UserService {

    User Save(User user);

    User FindByEmail(String email);
}

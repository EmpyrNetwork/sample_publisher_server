package com.empyr.api.consumer.repository;

import org.springframework.data.repository.CrudRepository;
import com.empyr.api.consumer.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}

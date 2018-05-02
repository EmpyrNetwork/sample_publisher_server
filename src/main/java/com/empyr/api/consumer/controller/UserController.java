package com.empyr.api.consumer.controller;

import com.empyr.api.consumer.Config;
import com.empyr.api.consumer.model.*;
import com.empyr.api.consumer.security.TokenAuthentication;
import com.empyr.api.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletResponse;

@RequestMapping(value="api/v1/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/register", method=RequestMethod.POST, produces = "application/json")
    public ResponseEntity register(@RequestBody RegisterRequest registerRequest, HttpServletResponse response) throws Exception {
        try {
            User user = new User();
            user.setEmail(registerRequest.getEmail());
            user.setPassword(registerRequest.getPassword());
            user.setFirstName(registerRequest.getFirstName());
            user.setLastName(registerRequest.getLastName());
            user.setSystemGeneratedEmail(Config.getAppName() + "-" + user.getEmail());
            User newUser = userService.Save(user);

            if(newUser == null){
                return new ResponseEntity<>("User already exists", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            TokenAuthentication.addAuthentication(response, user.getEmail());

            return new ResponseEntity<>(newUser, HttpStatus.OK);
        } catch (HttpClientErrorException ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
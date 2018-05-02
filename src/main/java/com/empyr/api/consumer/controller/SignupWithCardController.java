package com.empyr.api.consumer.controller;

import com.empyr.api.consumer.model.AccessToken;
import com.empyr.api.consumer.model.Address;
import com.empyr.api.consumer.model.SignupRequest;
import com.empyr.api.consumer.model.User;
import com.empyr.api.consumer.service.OAuthService;
import com.empyr.api.consumer.service.SignupWithCardService;
import com.empyr.api.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@RequestMapping(value="api/v1/user/signupWithCard")
@RestController
public class SignupWithCardController {

    @Autowired
    OAuthService OAuthService;

    @Autowired
    UserService userService;

    @Autowired
    SignupWithCardService signupWithCardService;

    @RequestMapping(value="", method=RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> signupWithCard(@RequestBody SignupRequest signupRequest) throws Exception {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String email = authentication.getPrincipal().toString();

            User user = userService.FindByEmail(email);
            if(user != null) {
                user.setAddress(signupRequest.getUser().getAddress());
                signupRequest.setUser(user);
                userService.Save(user);
            } else {
                return new ResponseEntity<>("You are not logged in.", HttpStatus.NOT_FOUND);
            }

            AccessToken accessToken = OAuthService.GetClientCredentialsToken();
            signupRequest.setAccess_token(accessToken.getToken());

            String resp = signupWithCardService.SignupWithCard(signupRequest);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (HttpClientErrorException ex){
            return new ResponseEntity<>(ex.getResponseBodyAsString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/{userToken}", method=RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> signupWithCard(@RequestBody SignupRequest signupRequest, @PathVariable("userToken") String userToken) throws Exception {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String email = authentication.getPrincipal().toString();

            User user = userService.FindByEmail(email);
            if(user != null) {
                user.setAddress(signupRequest.getUser().getAddress());
                signupRequest.setUser(user);
                userService.Save(user);
            } else {
                return new ResponseEntity<>("You are not logged in.", HttpStatus.NOT_FOUND);
            }

            AccessToken accessToken = OAuthService.GetClientUserToken(userToken);
            signupRequest.setUser_token(accessToken.getToken());

            String resp = signupWithCardService.SignupWithCard(signupRequest);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (HttpClientErrorException ex){
            return new ResponseEntity<>(ex.getResponseBodyAsString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
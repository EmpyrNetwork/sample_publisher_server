package com.empyr.api.consumer.service;

import com.empyr.api.EmpyrClient;
import com.empyr.api.consumer.Config;
import com.empyr.api.consumer.model.SignupRequest;
import com.empyr.api.consumer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SignupWithCardServiceImpl implements SignupWithCardService {

    @Autowired
    private UserRepository userRepository;

    public String SignupWithCard(SignupRequest req) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("access_token", req.getAccess_token());
        map.add("user_token", req.getUser_token());
        map.add("user.firstName", req.getUser().getFirstName());
        map.add("user.lastName", req.getUser().getLastName());
        map.add("user.email", req.getUser().getSystemGeneratedEmail());
        map.add("generatePassword", "true");
        map.add("user.address.postalCode", req.getUser().getAddress().getPostalCode());
        map.add("user.sendNotifications", "false");
        map.add("billingDetail.cardNumber", req.getBillingDetail().getCardNumber());
        map.add("billingDetail.expirationYear", req.getBillingDetail().getExpirationYear());
        map.add("billingDetail.expirationMonth", req.getBillingDetail().getExpirationMonth());

        String signupUrl = String.format("%s/users/signupWithCard?client_id=%s", Config.getAPIUrl(), Config.getAPIKey());

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(signupUrl, request , String.class );

        return response.getBody();
    }
}
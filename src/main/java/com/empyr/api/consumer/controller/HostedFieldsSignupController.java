package com.empyr.api.consumer.controller;

import com.empyr.api.consumer.Config;
import com.empyr.api.consumer.model.*;
import com.empyr.api.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;

@RequestMapping(value="api/v1/user/hostedFieldsSignup")
@RestController
public class HostedFieldsSignupController {

    @Autowired
    UserService userService;

    private static final String HMAC_SHA512 = "HmacSHA512";

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    private static byte[] calculateHMAC(String data, String key)
            throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
    {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), HMAC_SHA512);
        Mac mac = Mac.getInstance(HMAC_SHA512);
        mac.init(secretKeySpec);
        return mac.doFinal(data.getBytes());
    }

    @RequestMapping(value="/data", method=RequestMethod.POST, produces = "application/json")
    public ResponseEntity<UserData> getUserData(@RequestBody TokenRequest tokenRequest) throws Exception {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String email = authentication.getPrincipal().toString();

            User user = userService.FindByEmail(email);
            if(user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            String data = user.getSystemGeneratedEmail() + ":" + tokenRequest.getExpires_in();
            byte[] hmac = calculateHMAC(data, Config.getAPISecret());
            String base64 = java.util.Base64.getEncoder().encodeToString(hmac);

            UserData userData = new UserData();
            userData.setEmail(user.getSystemGeneratedEmail());
            userData.setFirstName(user.getFirstName());
            userData.setLastName(user.getLastName());
            userData.setToken(data + ':' + base64);

            return new ResponseEntity<>(userData, HttpStatus.OK);
        } catch (HttpClientErrorException ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
package com.empyr.api.consumer.controller;

import com.empyr.api.consumer.Config;
import com.empyr.api.consumer.model.Event;
import com.empyr.api.consumer.helper.Crypto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RequestMapping(value="api/v1/event")
@RestController
public class EventController {

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<String> receiveEvent(@RequestHeader HttpHeaders httpHeaders, @RequestBody String requestString) throws Exception {
        try {
            System.out.println("Request: " + requestString);
            Map<String,String> headerMap = httpHeaders.toSingleValueMap();
            String sig = headerMap.get("notifysignature");
            System.out.println("Notify Signature: " + sig);

            byte[] hmac = Crypto.calculateHMACSHA256(requestString, Config.getAPISecret());
            String result = Crypto.toHexString(hmac);
            System.out.println("Calculated Signature: " + result);

            // verify payload signature

            // INFORM USER OF EVENT

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
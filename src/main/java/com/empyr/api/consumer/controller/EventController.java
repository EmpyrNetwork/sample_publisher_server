package com.empyr.api.consumer.controller;

import com.empyr.api.consumer.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value="api/v1/event")
@RestController
public class EventController {

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<String> receiveEvent(@RequestBody Event event) throws Exception {
        try {

            // INFORM USER OF EVENT

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
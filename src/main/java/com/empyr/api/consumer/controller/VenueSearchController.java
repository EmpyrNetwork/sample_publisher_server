package com.empyr.api.consumer.controller;

import com.empyr.api.consumer.model.*;
import com.empyr.api.consumer.service.VenueSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RequestMapping(value="api/v1/venueSearch")
@RestController
public class VenueSearchController {

    @Autowired
    VenueSearchService venueSearchService;

    @RequestMapping(value="", method=RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> venueSearch(@RequestBody VenueSearchRequest venueSearchRequest) throws Exception {
        try {
            String resp = venueSearchService.VenueSearch(venueSearchRequest);

            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (HttpClientErrorException ex){
            return new ResponseEntity<>(ex.getResponseBodyAsString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
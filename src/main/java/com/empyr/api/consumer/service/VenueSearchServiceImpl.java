package com.empyr.api.consumer.service;

import com.empyr.api.consumer.Config;
import com.empyr.api.consumer.model.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class VenueSearchServiceImpl implements VenueSearchService {
    public String VenueSearch(VenueSearchRequest req) throws Exception {

        String venueSearchUrl = String.format("%s/venues/search?client_id=%s", Config.getAPIUrl(), Config.getAPIKey());

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<VenueSearchRequest> request = new HttpEntity<>(req);

        ResponseEntity<String> response
                = restTemplate.postForEntity(venueSearchUrl, request, String.class);

        return response.getBody();
    }
}

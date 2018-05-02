package com.empyr.api.consumer.service;

import com.empyr.api.consumer.model.VenueSearchRequest;

public interface VenueSearchService {
    String VenueSearch(VenueSearchRequest req) throws Exception;
}

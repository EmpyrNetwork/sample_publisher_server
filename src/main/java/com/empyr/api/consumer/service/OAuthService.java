package com.empyr.api.consumer.service;

import com.empyr.api.consumer.model.AccessToken;

public interface OAuthService {
    AccessToken GetClientCredentialsToken() throws Exception;

    AccessToken GetClientUserToken(String userToken) throws Exception;
}

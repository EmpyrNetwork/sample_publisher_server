package com.empyr.api.consumer.service;

import com.empyr.api.EmpyrClient;
import com.empyr.api.consumer.Config;
import com.empyr.api.consumer.model.AccessToken;
import com.empyr.api.model.OAuthResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class OAuthServiceImpl implements OAuthService {

    public AccessToken GetClientCredentialsToken() throws Exception {
        EmpyrClient client = new EmpyrClient(Config.getAPIKey(), Config.getAPISecret());

        OAuthResponse or = client.getAccessToken("client_credentials", new HashMap());

        AccessToken accessToken = new AccessToken();
        accessToken.setToken(or != null ? or.access_token : "");

        return accessToken;
    }

    public AccessToken GetClientUserToken(String userToken) throws Exception {
        EmpyrClient client = new EmpyrClient(Config.getAPIKey(), Config.getAPISecret());

        HashMap params = new HashMap<String, Object>();
        params.put("user_token", userToken);

        OAuthResponse or = client.getAccessToken("client_usertoken", params);

        AccessToken accessToken = new AccessToken();
        accessToken.setToken(or != null ? or.access_token : "");

        return accessToken;
    }
}


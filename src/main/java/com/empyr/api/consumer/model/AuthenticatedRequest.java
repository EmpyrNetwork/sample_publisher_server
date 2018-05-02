package com.empyr.api.consumer.model;

public abstract class AuthenticatedRequest {
    private String access_token;

    private String user_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String client_credentials_token) {
        this.access_token = client_credentials_token;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }
}

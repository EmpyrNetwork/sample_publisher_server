package com.empyr.api.consumer;

public class Config {
    public static String getAppName(){
        String appName = System.getenv("MOGL_APP_NAME");
        if(appName == null){
            appName = "testmogl";
        }
        return appName;
    }

    public static String getAPIKey(){
        String apiKey = System.getenv("MOGL_API_KEY");
        if(apiKey == null){
            throw new IllegalStateException("Missing MOGL_API_KEY");
        }
        return apiKey;
    }

    public static String getAPISecret(){
        String apiSecret = System.getenv("MOGL_API_SECRET");
        if(apiSecret == null){
            throw new IllegalStateException("Missing MOGL_API_SECRET");
        }
        return apiSecret;
    }

    public static String getBaseUrl(){
        String baseUrl = System.getenv("MOGL_BASE_URL");
        if(baseUrl == null){
            baseUrl = "https://test.mogl.com";
        }
        return baseUrl;
    }

    public static String getAPIUrl(){
        String apiUrl = System.getenv("MOGL_API_URL");
        if(apiUrl == null){
            apiUrl = "https://test.mogl.com/api/v2";
        }
        return apiUrl;
    }

    public static String getJwtSecret(){
        String jwtSecret = System.getenv("MOGL_JWT_SECRET");
        if(jwtSecret == null){
            jwtSecret = "hippopotamus";
        }
        return jwtSecret;
    }
}

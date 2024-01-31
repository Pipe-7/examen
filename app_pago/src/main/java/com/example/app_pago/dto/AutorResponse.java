package com.example.app_pago.dto;

import java.io.Serializable;

public class AutorResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String token;
    private final String userName;
    private final String accessTokenExpiration;
    public AutorResponse(String token, String userName, String accessTokenExpiration) {
        this.token = token;
        this.userName = userName;
        this.accessTokenExpiration = accessTokenExpiration;
    }
    public String getToken() {
        return token;
    }
    public String getUserName() {
        return userName;
    }
    public String getAccessTokenExpiration() {
        return accessTokenExpiration;
    }
}

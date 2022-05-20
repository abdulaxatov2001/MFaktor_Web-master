package com.example.authservice.utils;

public enum TokenClaim {

    USER_ID("userId"), USER_INFO("UserInfo"), AUTHORITIES("authorities");

    private String key;

    private TokenClaim(final String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}

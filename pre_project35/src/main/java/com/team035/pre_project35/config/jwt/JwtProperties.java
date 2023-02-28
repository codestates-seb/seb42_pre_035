package com.team035.pre_project35.config.jwt;

public interface JwtProperties {
    String SECRET = "pre";
    int EXPIRATION_TIME = 43200000;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}

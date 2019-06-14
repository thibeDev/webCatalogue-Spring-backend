package com.thibaut.catservice.security;

public class SecurityConstants {
    public static final String SECRET = "thibaut.gobert@hotmail.com";
    public static final long EXPIRATION_TIME = 10*24*3600; //10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING  = "Authorization";
}

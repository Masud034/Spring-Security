package com.example.springsecurity.security;

import lombok.Getter;
import lombok.Setter;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 86400000;
    public static final String TOKEN_PREFIX = "BEARER ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/admin/add";
    public static final String TOKEN_SECRET = "j95f54fg457";
}

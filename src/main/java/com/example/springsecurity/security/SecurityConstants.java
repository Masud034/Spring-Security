package com.example.springsecurity.security;

import lombok.Getter;
import lombok.Setter;

public class SecurityConstants {
    private static final long EXPIRATION_TIME = 86400000;
    private static final String TOKEN_PREFIX = "BEARER ";
    private static final String HEADER_STRING = "Authorization";
    private static final String SIGN_UP_URL = "admin/add";
    private static final String TOKEN_SECRET = "j95f54fg457";
}

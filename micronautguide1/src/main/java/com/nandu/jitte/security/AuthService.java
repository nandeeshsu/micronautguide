package com.nandu.jitte.security;

import jakarta.inject.Singleton;

@Singleton
public class AuthService {
    public String verifyToken(String token) {
        return "token:: " + token + " verified";
    }
}

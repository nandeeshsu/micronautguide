package com.nandu.jitte.security.exception;

public class AuthException extends RuntimeException{

    public AuthException(String need_authorization_token) {
        super(need_authorization_token);
    }
}

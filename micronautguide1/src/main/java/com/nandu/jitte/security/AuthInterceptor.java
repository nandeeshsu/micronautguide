package com.nandu.jitte.security;

import com.nandu.jitte.security.exception.AuthException;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.http.HttpRequest;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Singleton
@Slf4j
public class AuthInterceptor implements MethodInterceptor<Object, Object> {

    @Inject
    AuthService authService;

    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {
        Map<String, Object> valueMap = context.getParameterValueMap();

        String token = (String) valueMap.get("authorizationHeader1");
        if(token == null || token.isEmpty()) {
            log.info("Authorization is null or empty");
            throw new AuthException("Need Authorization token");
        }

        return context.proceed ();
    }

    /*@Override
    public Object intercept(MethodInvocationContext<HttpRequest<Object>, Object> context) {
        log.info("checking the authorization");
        context.getParameterValueMap().forEach((name, value) -> {
            if(value instanceof HttpRequest) {
                HttpRequest<Object> request = (HttpRequest<Object>) value;
                String token = request.getHeaders().get("Auth");

                if(token == null || token.isEmpty()) {
                    log.info("Authorization is null or empty");
                    throw new AuthException("Need Authorization token");
                }

                request.setAttribute("session",authService.verifyToken(token));
            }
        } );
        return context.proceed ();
    }*/
}

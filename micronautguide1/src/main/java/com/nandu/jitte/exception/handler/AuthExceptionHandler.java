package com.nandu.jitte.exception.handler;

import com.nandu.jitte.model.ErrorMessage;
import com.nandu.jitte.security.exception.AuthException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {AuthException.class, ExceptionHandler.class})
public class AuthExceptionHandler implements ExceptionHandler<AuthException, HttpResponse<ErrorMessage>> {
    @Override
    public HttpResponse<ErrorMessage> handle(HttpRequest request, AuthException exception) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(exception.getMessage())
                .status(false).build();

        return HttpResponse
                .serverError(errorMessage)
                .status(HttpStatus.FORBIDDEN);
    }
}

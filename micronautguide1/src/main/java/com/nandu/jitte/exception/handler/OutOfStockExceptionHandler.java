package com.nandu.jitte.exception.handler;

import com.nandu.jitte.exception.OutOfStockException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.http.server.exceptions.response.ErrorContext;
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor;
import jakarta.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {OutOfStockException.class, ExceptionHandler.class})
public class OutOfStockExceptionHandler implements ExceptionHandler<OutOfStockException, HttpResponse<?>> {

    private final ErrorResponseProcessor<?> errorResponseProcessor;

    public OutOfStockExceptionHandler(ErrorResponseProcessor<?> errorResponseProcessor) {
        this.errorResponseProcessor = errorResponseProcessor;
    }

    @Override
    public HttpResponse<?> handle(HttpRequest request, OutOfStockException exception) {
        return errorResponseProcessor.processResponse(ErrorContext.builder(request)
                .cause(exception)
                .errorMessage("No stock available")
                .build(), HttpResponse.badRequest()); //
    }
}

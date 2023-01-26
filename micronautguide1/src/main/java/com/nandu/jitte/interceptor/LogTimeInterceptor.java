package com.nandu.jitte.interceptor;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.http.HttpRequest;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;

@Singleton
@Slf4j
public class LogTimeInterceptor implements MethodInterceptor<Object, Object> {
    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {

        Instant start = Instant.now();

        try {
            return context.proceed();
        }finally {
            Instant finish = Instant.now();
            log.info("StopWatch Task name:{} running time:{} sec",
                    context.getDeclaringType().getSimpleName() + "." + context.getName(),
                    Duration.between(start, finish).toMillis()/1000F);
        }
    }
}

package com.bootcamptoprod.retry.config;

import com.bootcamptoprod.retry.exception.MovieNotFoundException;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.time.Duration;

@Configuration
public class RetryConfiguration {

    @Autowired
    private RetryRegistry retryRegistry;

    @Bean
    public Retry retryWithCustomConfig() {
        RetryConfig customConfig = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofSeconds(2))
                .retryExceptions(HttpClientErrorException.class, HttpServerErrorException.class)
                .ignoreExceptions(MovieNotFoundException.class)
                .build();

        return retryRegistry.retry("customRetryConfig", customConfig);
    }
}

package com.converter.gateway.filter;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;

/**
 * Global filter that logs incoming requests and responses with duration.
 */
@Component
public class RequestLoggingFilter implements GlobalFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        var request = exchange.getRequest();
        String id = UUID.randomUUID().toString();
        long start = System.currentTimeMillis();

        log.info("[{}] -> {} {} from={} headers={}", id,
                request.getMethod(), request.getURI(), request.getRemoteAddress(), request.getHeaders());

        return chain.filter(exchange)
                .doOnError(err -> log.warn("[{}] -> error: {}", id, err.toString()))
                .doFinally(signal -> {
                    HttpStatusCode status = exchange.getResponse().getStatusCode();
                    long duration = System.currentTimeMillis() - start;
                    log.info("[{}] <- {} {} status={} timeMs={}", id,
                            request.getMethod(), request.getURI(),
                            status != null ? status.value() : "N/A", duration);
                });
    }
}

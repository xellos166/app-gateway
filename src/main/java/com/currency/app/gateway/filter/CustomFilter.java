package com.currency.app.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class CustomFilter implements GlobalFilter, Ordered {

    final Logger logger =
            LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("First Pre Global Filter");
        HttpHeaders headers = exchange.getRequest().getHeaders();
        headers.forEach((key, value) -> {
            logger.info(String.format("Header '%s' = %s", key, value));
        });
        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    logger.info(exchange.getResponse().toString());
                    logger.info("Last Post Global Filter");
                }));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}

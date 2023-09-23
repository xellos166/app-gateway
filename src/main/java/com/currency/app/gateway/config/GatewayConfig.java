package com.currency.app.gateway.config;

import com.currency.app.gateway.filter.CustomFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public CustomFilter customFilter() {
        return  new CustomFilter();
    }
}

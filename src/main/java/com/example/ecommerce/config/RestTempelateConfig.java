package com.example.ecommerce.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestTempelateConfig {
    @Bean
public RestTemplate getRestTemplate() {
    return new RestTemplateBuilder().build();
}
}

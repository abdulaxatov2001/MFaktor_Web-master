package com.example.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
//@RequiredArgsConstructor
public class RouteConfig {

    @Autowired
    @Lazy
    AuthFilter authFilter;

    //TODO ishlamayapti
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/api/admin/**")
//                        .filters(f -> f.removeRequestHeader("Authorization")
//                                .filter(authFilter.apply(new AuthFilterConfig())))
//                                .uri("localhost:8082/api/admin/**")).build();
//    }
}


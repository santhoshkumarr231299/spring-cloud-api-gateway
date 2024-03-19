package com.realstar.apigateway.config;

import com.realstar.apigateway.filters.FirstLevelFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route("google", r -> r.path("/**").filters(f -> f.filter(new FirstLevelFilter(), 1)).uri("https://www.google.com")).build();
//        .route("zoho", r -> r.path("/second/**").filters(f -> f.stripPrefix(1)).uri("https://www.xyz.com")).build(); 
//        This uses a context path to route a url but some cases we have to strip the context path to work.
    }
}

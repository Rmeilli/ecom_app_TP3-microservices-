package org.sid.gateway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient

public class Gateway2Application {

    public static void main(String[] args) {
        SpringApplication.run(Gateway2Application.class, args);
    }

//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder){
//        return builder.routes()
////                .route(r -> r.path("/customers/**").uri("http://localhost:8081/"))
////                .route( r -> r.path("/products/**").uri("http://localhost:8085/"))
//
//                .route(r -> r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
//                .route( r -> r.path("/products/**").uri("lb://INVENTORYSERVICE"))
//                 .build();
//
//    }
    @Bean
    public DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }
}

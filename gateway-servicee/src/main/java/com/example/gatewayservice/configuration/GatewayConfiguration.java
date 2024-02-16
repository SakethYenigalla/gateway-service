package com.example.gatewayservice.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;


@Configuration
public class GatewayConfiguration {
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("employee_service_get_all", r -> r.method(HttpMethod.GET).and().path("/Employee/Data/All")
                        .uri("http://localhost:8081"))
                .route("employee_service_get_by_id", r -> r.method(HttpMethod.GET).and().path("/Employee/Data/{id}")
                        .uri("http://localhost:8081"))
                .route("employee_service_save", r -> r.method(HttpMethod.POST).and().path("/Employee/Data")
                        .uri("http://localhost:8081"))
                .route("employee_service_delete", r -> r.method(HttpMethod.DELETE).and().path("/Employee/{id}")
                        .uri("http://localhost:8081"))
                .route("employee_address_service_get_all", r -> r.method(HttpMethod.GET).and().path("/Address/All")
                        .uri("http://localhost:8082"))
                .route("employee_address_service_get_by_id", r -> r.method(HttpMethod.GET).and().path("/Address/{id}")
                        .uri("http://localhost:8082"))
                .route("employee_address_service_save", r -> r.method(HttpMethod.POST).and().path("/Address/save")
                        .uri("http://localhost:8082"))
                .route("employee_address_service_delete", r -> r.method(HttpMethod.DELETE).and().path("/Address/{id}")
                        .uri("http://localhost:8082"))
                .build();
    }
}

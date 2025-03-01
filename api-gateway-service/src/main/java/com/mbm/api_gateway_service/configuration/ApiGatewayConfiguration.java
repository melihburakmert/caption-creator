package com.mbm.api_gateway_service.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    private final ServiceBaseUrlProperties serviceBaseUrlProperties;

    public ApiGatewayConfiguration(final ServiceBaseUrlProperties serviceBaseUrlProperties) {
        this.serviceBaseUrlProperties = serviceBaseUrlProperties;
    }

    @Bean
    public RouteLocator gatewayRouter(final RouteLocatorBuilder builder) {
        return builder.routes()
                // Route for Playback Data Service
                .route(r -> r.path("/playback/**")
                        .uri(serviceBaseUrlProperties.getPlaybackDataService()))

                // Route for GenAI Service
                .route(r -> r.path("/genai/**")
                        .uri(serviceBaseUrlProperties.getGenAiService()))

                .build();
    }

}

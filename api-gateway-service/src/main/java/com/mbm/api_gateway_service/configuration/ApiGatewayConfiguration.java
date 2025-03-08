package com.mbm.api_gateway_service.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class ApiGatewayConfiguration {

    private static final List<String> ALLOWED_METHODS = List.of("GET", "POST", "PUT", "DELETE", "OPTIONS");
    private static final List<String> ALLOWED_HEADERS = List.of("*");

    private final ServiceBaseUrlProperties serviceBaseUrlProperties;

    public ApiGatewayConfiguration(final ServiceBaseUrlProperties serviceBaseUrlProperties) {
        this.serviceBaseUrlProperties = serviceBaseUrlProperties;
    }

    @Bean
    public RouteLocator gatewayRouter(final RouteLocatorBuilder builder) {
        return builder.routes()
            .route(r -> r.path("/playback/**")
                    .filters(GatewayFilterSpec::preserveHostHeader)
                    .uri(serviceBaseUrlProperties.getPlaybackDataService()))

            .route(r -> r.path("/genai/**")
                    .uri(serviceBaseUrlProperties.getGenAiService()))

            .build();
    }

    @Bean
    public CorsWebFilter corsFilter() {
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of(serviceBaseUrlProperties.getFrontendService()));
        config.setAllowedMethods(ALLOWED_METHODS);
        config.setAllowedHeaders(ALLOWED_HEADERS);
        config.setAllowCredentials(true);

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
}

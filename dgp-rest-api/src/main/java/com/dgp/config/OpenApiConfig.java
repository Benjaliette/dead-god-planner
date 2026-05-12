package com.dgp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Value("${app.openapi.server-url}")
    private String serverUrl;

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .servers(List.of(new Server().url(serverUrl).description("API Server")))
                .info(new Info()
                        .title("Dead God Planner API Documentation")
                        .version("0.1.0-SNAPSHOT")
                        .description("Documentation OpenAPI pour tester et récupérer les informations de The Binding " +
                                "of Isaac : Repentance")
                );
    }
}

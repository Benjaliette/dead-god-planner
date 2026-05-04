package com.dgp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Dead God Planner API Documentation")
                        .version("0.1.0-SNAPSHOT")
                        .description("Documentation OpenAPI pour tester et récupérer les informations de The Binding " +
                                "of Isaac : Repentance")
                );
    }
}

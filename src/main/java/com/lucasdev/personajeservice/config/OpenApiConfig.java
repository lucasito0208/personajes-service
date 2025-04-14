package com.lucasdev.personajeservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Servicio de Personajes - Elden Ring")
                        .version("1.0.0")
                        .description("Microservicio Reactivo para la gestión de personajes del universo Elden Ring"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("personajes")
                .pathsToMatch("/personajes", "/clases")
                .build();
    }
}

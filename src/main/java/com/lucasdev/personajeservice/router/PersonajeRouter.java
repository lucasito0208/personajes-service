package com.lucasdev.personajeservice.router;

import com.lucasdev.personajeservice.handler.PersonajeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class PersonajeRouter {

    @Bean
    public RouterFunction<ServerResponse> personajeRutas(PersonajeHandler handler) {
        return RouterFunctions
                .route(GET("/personajes"), handler::findAll)
                .andRoute(GET("/clases"), handler::getAllClases)
                .andRoute(GET("/personajes/{id}"), handler::findById)
                .andRoute(POST("/personajes"), handler::save)
                .andRoute(DELETE("/personajes/{id}"), handler::delete);
    }
}

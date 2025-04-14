package com.lucasdev.personajeservice.handler;

import com.lucasdev.personajeservice.modelo.ClasePersonaje;
import com.lucasdev.personajeservice.modelo.Personaje;
import com.lucasdev.personajeservice.servicio.ClaseService;
import com.lucasdev.personajeservice.servicio.PersonajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Tag(name = "Personajes", description = "Endpoints para la gestión de personajes de EldenRing")
public class PersonajeHandler {

    private final PersonajeService service;
    private final ClaseService claseService;

    public PersonajeHandler(PersonajeService service, ClaseService claseService) {
        this.service = service;
        this.claseService = claseService;
    }

    @Operation(summary = "Listar todos los personajes creados")
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Personaje.class);
    }

    @Operation(summary = "Listar todas las clases disponibles")
    public Mono<ServerResponse> getAllClases(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(claseService.findAll(), ClasePersonaje.class);
    }

    @Operation(summary = "Muestra un personaje concreto")
    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return service.findById(id)
                .flatMap(p -> ServerResponse.ok().bodyValue(p))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
    /*
    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(Personaje.class)
                .flatMap(personaje -> claseService.existsByNombre(personaje.getClase())
                        .flatMap(existe -> {
                            if (existe) {
                                return personajeService.save(personaje)
                                        .flatMap(saved -> ServerResponse
                                                .status(HttpStatus.CREATED)
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .bodyValue(saved));
                            } else {
                                return ServerResponse.badRequest()
                                        .bodyValue("Clase no válida");
                            }
                        }));
    }

    */
    @Operation(summary = "Añade un personaje a la base de datos")
    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(Personaje.class)
                .flatMap(personaje ->
                        claseService.exists(personaje.getClase())
                                .flatMap(existe -> {
                                    if (existe) {
                                        return service.save(personaje)
                                                .flatMap(saved -> ServerResponse.status(HttpStatus.CREATED)
                                                        .contentType(MediaType.APPLICATION_JSON)
                                                        .bodyValue(saved));
                                    } else {
                                        return ServerResponse.badRequest()
                                                .bodyValue("Clase no válida o no encontrada.");
                                    }
                                })
                );
    }
    @Operation(summary = "Elimina un personaje de la base de datos")
    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");
        return service.delete(id)
                .then(ServerResponse.noContent().build());
    }


}

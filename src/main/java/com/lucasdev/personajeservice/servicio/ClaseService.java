package com.lucasdev.personajeservice.servicio;

import com.lucasdev.personajeservice.modelo.ClasePersonaje;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClaseService {

    public Flux<ClasePersonaje> findAll() {
        return Flux.fromArray(ClasePersonaje.values());
    }

    public Mono<Boolean> exists(ClasePersonaje clase) {
        return Mono.just(clase != null);
    }
}

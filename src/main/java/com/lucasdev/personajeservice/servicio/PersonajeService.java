package com.lucasdev.personajeservice.servicio;

import com.lucasdev.personajeservice.modelo.ClasePersonaje;
import com.lucasdev.personajeservice.modelo.Personaje;
import com.lucasdev.personajeservice.repositorio.PersonajeRepositorio;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonajeService {

    private final PersonajeRepositorio personajeRepositorio;

    public PersonajeService(PersonajeRepositorio personajeRepositorio) {
        this.personajeRepositorio = personajeRepositorio;
    }

    public Flux<Personaje> findAll() {
        return personajeRepositorio.findAll();
    }

    public Mono<Personaje> findById(String id) {
        return personajeRepositorio.findById(id);
    }

    public Mono<Personaje> save(Personaje personaje) {
        return personajeRepositorio.save(personaje);
    }

    public Mono<Void> delete(String id) {
        return personajeRepositorio.deleteById(id);
    }

    public Flux<ClasePersonaje> getAllClasses() {
        return Flux.fromArray(ClasePersonaje.values());
    }
}

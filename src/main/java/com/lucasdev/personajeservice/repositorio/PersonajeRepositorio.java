package com.lucasdev.personajeservice.repositorio;

import com.lucasdev.personajeservice.modelo.Personaje;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonajeRepositorio extends ReactiveMongoRepository<Personaje, String> {

}

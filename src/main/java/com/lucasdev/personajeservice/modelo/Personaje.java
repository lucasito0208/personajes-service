package com.lucasdev.personajeservice.modelo;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "personajes")
@Schema(description = "Entidad que representa un personaje del universo Elden Ring")
public class Personaje {

    @Id
    @Schema(description = "ID único del personaje", example = "507f1f77bcf86cd799439011")
    private String id;

    @Schema(description = "Nombre del personaje", example = "Ranni")
    private String nombre;

    @Schema(description = "Clase del personaje", example = "MAGO")
    private ClasePersonaje clase;

    @Schema(description = "Nivel del personaje", example = "45")
    private Integer nivel;

    public Personaje(String id, String nombre, ClasePersonaje clase, Integer nivel) {
        this.id = id;
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
    }

    public Personaje() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ClasePersonaje getClase() {
        return clase;
    }

    public void setClase(ClasePersonaje clase) {
        this.clase = clase;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}

package com.lucasdev.personajeservice.dto;

import java.util.List;

public record ErrorHandler(int status, String mensaje, List<String> errores) {
}

package com.lucasdev.personajeservice.handler;



import com.lucasdev.personajeservice.dto.ErrorHandler;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public Mono<ServerResponse> handlerValidationException(ConstraintViolationException ex) {

        List<String> errores = ex.getConstraintViolations().stream()
                .map(error -> error.getPropertyPath() + ":" + error.getMessage())
                .collect(Collectors.toList());

        ErrorHandler respuesta = new ErrorHandler(
                HttpStatus.BAD_REQUEST.value(),
                "Validación fallida.",
                errores
        );

        return ServerResponse
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(respuesta);

    }

    @ExceptionHandler(Exception.class)
    public Mono<ServerResponse> handlerGeneralError(Exception ex) {
        ErrorHandler respuesta = new ErrorHandler(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Error interno del servidor",
                List.of(ex.getMessage())
        );

        return ServerResponse
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(respuesta);
    }
}

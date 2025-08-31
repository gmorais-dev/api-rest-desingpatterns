package com.formulario.form.Exceptions;

import com.formulario.form.messages.ApiErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiErrorMessage> handleValidationException(ValidationException e, HttpServletRequest request) {
        ApiErrorMessage error = new ApiErrorMessage();
        error.setStatus(HttpStatus.BAD_REQUEST.value()); // 400
        error.setTimestamp(Instant.now());
        error.setError("Erro de validação");
        error.setMessage(e.getMessage()); // Mensagem da validação
        error.setPath(request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorMessage> handleResourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        ApiErrorMessage error = new ApiErrorMessage();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(Instant.now());
        error.setError("Recurso não encontrado");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorMessage> handleGenericException(Exception e, HttpServletRequest request) {
        ApiErrorMessage error = new ApiErrorMessage();
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimestamp(Instant.now());
        error.setError("Erro interno do servidor");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
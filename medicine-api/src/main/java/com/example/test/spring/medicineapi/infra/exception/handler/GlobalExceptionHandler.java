package com.example.test.spring.medicineapi.infra.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.test.spring.medicineapi.infra.exception.ErrorResponse;
import com.example.test.spring.medicineapi.infra.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> tratar404(ResourceNotFoundException ex) {

        return ResponseEntity
                .status(404)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratar400(MethodArgumentNotValidException ex) {

        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest()
                .body(erros.stream().map(DadosErroValidacao::new).toList());
    }

    public record DadosErroValidacao(String campo, String mensagem) {

        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
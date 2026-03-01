package com.example.test.spring.testando.remedio.dto.request;

import com.example.test.spring.testando.remedio.domain.Laboratorio;
import com.example.test.spring.testando.remedio.domain.Via;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(

    @NotNull
    Long id,
    String nome,
	Via via,
	Laboratorio laboratorio) {

}

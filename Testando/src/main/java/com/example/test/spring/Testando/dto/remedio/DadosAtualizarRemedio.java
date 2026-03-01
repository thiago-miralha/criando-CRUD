package com.example.test.spring.Testando.dto.remedio;

import com.example.test.spring.Testando.enums.Laboratorio;
import com.example.test.spring.Testando.enums.Via;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(

    @NotNull
    Long id,
    String nome,
	Via via,
	Laboratorio laboratorio) {

}

package com.example.test.spring.medicineapi.remedio.dto.request;

import com.example.test.spring.medicineapi.remedio.domain.Laboratorio;
import com.example.test.spring.medicineapi.remedio.domain.Via;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(

    @NotNull
    Long id,
    String nome,
	Via via,
	Laboratorio laboratorio) {

}

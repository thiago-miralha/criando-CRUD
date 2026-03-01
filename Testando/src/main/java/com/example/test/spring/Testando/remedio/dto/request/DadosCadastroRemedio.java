package com.example.test.spring.testando.remedio.dto.request;

import java.time.LocalDate;

import com.example.test.spring.testando.remedio.domain.Laboratorio;
import com.example.test.spring.testando.remedio.domain.Via;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRemedio(
	
	@NotBlank
    String nome,
	
	@Enumerated
	Via via,

	@NotBlank
	String lote, 

	int quantidade,
	
	@Future
	LocalDate validade,

	@Enumerated
	Laboratorio laboratorio)
{

}

package com.example.test.spring.medicineapi.remedio.dto.request;

import java.time.LocalDate;

import com.example.test.spring.medicineapi.remedio.domain.Laboratorio;
import com.example.test.spring.medicineapi.remedio.domain.Via;

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

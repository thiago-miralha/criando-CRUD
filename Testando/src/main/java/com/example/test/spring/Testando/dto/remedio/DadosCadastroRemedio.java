package com.example.test.spring.Testando.dto.remedio;

import java.time.LocalDate;

import com.example.test.spring.Testando.enums.Laboratorio;
import com.example.test.spring.Testando.enums.Via;

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

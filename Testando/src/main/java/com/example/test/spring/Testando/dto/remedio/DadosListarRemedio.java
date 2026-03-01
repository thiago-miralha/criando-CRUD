package com.example.test.spring.Testando.dto.remedio;

import java.time.LocalDate;

import com.example.test.spring.Testando.entity.RemedioEntity;
import com.example.test.spring.Testando.enums.Laboratorio;
import com.example.test.spring.Testando.enums.Via;

public record DadosListarRemedio(
    Long id,
    String nome,
	Via via,
	String lote, 
	int quantidade,
	LocalDate validade,
	Laboratorio laboratorio) {


        public DadosListarRemedio (RemedioEntity remedio) {

            this(remedio.getId(),remedio.getNome(),remedio.getVia(),remedio.getLote(),remedio.getQuantidade(),remedio.getValidade(),remedio.getLaboratorio());


        }
}

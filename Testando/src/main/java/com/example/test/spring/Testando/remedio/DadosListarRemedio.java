package com.example.test.spring.Testando.remedio;

import java.time.LocalDate;

import com.example.test.spring.Testando.remedio.entity.RemedioEntity;

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

package com.example.test.spring.medicineapi.remedio.dto.response;

import java.time.LocalDate;

import com.example.test.spring.medicineapi.remedio.domain.Laboratorio;
import com.example.test.spring.medicineapi.remedio.domain.Remedio;
import com.example.test.spring.medicineapi.remedio.domain.Via;

public record DadosDetalhamentoRemedio( 
    Long id,
    String nome,
	Via via,
	String lote, 
	int quantidade,
	LocalDate validade,
	Laboratorio laboratorio,
    Boolean ativo
    
) {

          public DadosDetalhamentoRemedio (Remedio remedio) {

            this(remedio.getId(),
            remedio.getNome(),
            remedio.getVia(),
            remedio.getLote(),
            remedio.getQuantidade(),
            remedio.getValidade(),
            remedio.getLaboratorio(),
            remedio.getAtivo()
        );


        }

}

package com.example.test.spring.Testando.remedio.entity;

import com.example.test.spring.Testando.remedio.Laboratorio;
import com.example.test.spring.Testando.remedio.Via;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "Remedios")
@Entity(name = "remedio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RemedioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;


    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private String quantidade;
    private String validade;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;
}

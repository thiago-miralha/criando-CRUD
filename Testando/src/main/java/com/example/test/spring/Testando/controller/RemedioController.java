package com.example.test.spring.Testando.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.spring.Testando.remedio.DadosCadastroRemedio;
import com.example.test.spring.Testando.remedio.entity.RemedioEntity;
import com.example.test.spring.Testando.remedio.repository.RemedioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/remedio")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroRemedio dados) {

        repository.save(new RemedioEntity(dados));

    }

}

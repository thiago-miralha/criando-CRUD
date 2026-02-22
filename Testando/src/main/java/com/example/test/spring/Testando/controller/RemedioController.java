package com.example.test.spring.Testando.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.spring.Testando.remedio.DadosCadastroRemedio;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/remedio")
public class RemedioController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroRemedio dados) {

        System.out.println(dados);

    }

}

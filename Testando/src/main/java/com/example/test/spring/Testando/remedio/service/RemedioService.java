package com.example.test.spring.testando.remedio.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.spring.testando.remedio.*;
import com.example.test.spring.testando.remedio.domain.Remedio;
import com.example.test.spring.testando.remedio.dto.request.DadosAtualizarRemedio;
import com.example.test.spring.testando.remedio.dto.request.DadosCadastroRemedio;
import com.example.test.spring.testando.remedio.dto.response.DadosDetalhamentoRemedio;
import com.example.test.spring.testando.remedio.dto.response.DadosListarRemedio;
import com.example.test.spring.testando.remedio.repository.RemedioRepository;

import jakarta.transaction.Transactional;

@Service
public class RemedioService {

    @Autowired
    private RemedioRepository repository;

    @Transactional
    public DadosDetalhamentoRemedio cadastrar(DadosCadastroRemedio dados) {
        var remedio = new Remedio(dados);
        repository.save(remedio);
        return new DadosDetalhamentoRemedio(remedio);
    }

    public DadosDetalhamentoRemedio buscar(Long id) {
        var remedio = repository.getReferenceById(id);
        return new DadosDetalhamentoRemedio(remedio);
    }

    public List<DadosListarRemedio> listar() {
        return repository.findAllByAtivoTrue()
                .stream()
                .map(DadosListarRemedio::new)
                .toList();
    }

    @Transactional
    public DadosDetalhamentoRemedio atualizar(DadosAtualizarRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
        return new DadosDetalhamentoRemedio(remedio);
    }

    @Transactional
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void inativar(Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.inativar();
    }

    @Transactional
    public void reativar(Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.reativar();
    }
}


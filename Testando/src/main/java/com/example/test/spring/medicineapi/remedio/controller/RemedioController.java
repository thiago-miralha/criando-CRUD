package com.example.test.spring.medicineapi.remedio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.test.spring.medicineapi.remedio.dto.request.DadosAtualizarRemedio;
import com.example.test.spring.medicineapi.remedio.dto.request.DadosCadastroRemedio;
import com.example.test.spring.medicineapi.remedio.dto.response.DadosDetalhamentoRemedio;
import com.example.test.spring.medicineapi.remedio.dto.response.DadosListarRemedio;
import com.example.test.spring.medicineapi.remedio.service.RemedioService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados,
            UriComponentsBuilder uriBuilder) {

        var dto = service.cadastrar(dados);

        var uri = uriBuilder.path("/remedio/{id}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoRemedio> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));

    }

    @GetMapping
    public ResponseEntity<List<DadosListarRemedio>> listar() {
        return ResponseEntity.ok(service.listar());

    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@RequestBody @Valid DadosAtualizarRemedio dados) {

        return ResponseEntity.ok(service.atualizar(dados));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        service.inativar(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id) {
        service.reativar(id);
        return ResponseEntity.noContent().build();

    }

}

package com.example.test.spring.medicineapi.usuarios.autenticacao;

import org.springframework.web.bind.annotation.RestController;

import com.example.test.spring.medicineapi.usuarios.domain.Usuario;
import com.example.test.spring.medicineapi.usuarios.repository.UsuarioRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping("/login")
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {

        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autenticacao = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastrologin")
    public ResponseEntity<?> cadastroLogin(@RequestBody @Valid DadosCadastroAutenticacao dados) {
        if (this.repository.findByLogin(dados.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BcryptPassword4jPasswordEncoder().encode(dados.senha());
        Usuario newUsuario = new Usuario(dados.login(), encryptedPassword, dados.role());

        this.repository.save(newUsuario);
        return ResponseEntity.ok().build();

    }

}

package com.example.test.spring.medicineapi.usuarios.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.spring.medicineapi.infra.security.TokenService;
import com.example.test.spring.medicineapi.usuarios.domain.Usuario;
import com.example.test.spring.medicineapi.usuarios.repository.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    @Autowired
    TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping("/login")
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(usernamePassword);
        var tokenJWT = tokenService.generateToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(tokenJWT));
    }

    @PostMapping("/cadastrologin")
    public ResponseEntity<?> cadastroLogin(@RequestBody @Valid DadosCadastroAutenticacao dados) {

    if (this.repository.findByLogin(dados.login()) != null) {
        return ResponseEntity.badRequest().build();
    }

    String encryptedPassword = new BCryptPasswordEncoder().encode(dados.senha());

    Usuario newUsuario = new Usuario(dados.login(), encryptedPassword, dados.role());

    this.repository.save(newUsuario);

    return ResponseEntity.ok().build();
}

}

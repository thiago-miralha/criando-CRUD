package com.example.test.spring.medicineapi.usuarios.autenticacao;

import com.example.test.spring.medicineapi.usuarios.domain.UserRole;

public record DadosCadastroAutenticacao(String login,String senha,UserRole role) {

}

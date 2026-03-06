package com.example.test.spring.medicineapi.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.test.spring.medicineapi.usuarios.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    UserDetails findByLogin(String login);

    


}

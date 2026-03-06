package com.example.test.spring.medicineapi.remedio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.spring.medicineapi.remedio.domain.Remedio;

public interface RemedioRepository extends JpaRepository <Remedio,Long> {

    List<Remedio> findAllByAtivoTrue(); 

    
}

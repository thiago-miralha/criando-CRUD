package com.example.test.spring.Testando.remedio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.spring.Testando.remedio.entity.RemedioEntity;

public interface RemedioRepository extends JpaRepository <RemedioEntity,Long> {

    List<RemedioEntity> findAllByAtivoTrue(); 

    
}

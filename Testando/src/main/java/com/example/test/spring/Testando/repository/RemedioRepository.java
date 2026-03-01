package com.example.test.spring.Testando.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.spring.Testando.entity.RemedioEntity;

public interface RemedioRepository extends JpaRepository <RemedioEntity,Long> {

    List<RemedioEntity> findAllByAtivoTrue(); 

    
}

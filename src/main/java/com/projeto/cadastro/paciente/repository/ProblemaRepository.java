package com.projeto.cadastro.paciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.cadastro.paciente.entity.Problema;

@Repository
public interface ProblemaRepository extends JpaRepository<Problema, Integer>{
    
}

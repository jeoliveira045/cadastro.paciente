package com.projeto.cadastro.paciente.service;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.cadastro.paciente.dto.ProblemaDTO;
import com.projeto.cadastro.paciente.entity.Problema;
import com.projeto.cadastro.paciente.repository.ProblemaRepository;

@Service
public class ProblemaService {
    
    @Autowired
    ProblemaRepository repository;

    public Problema adicionarProblema(Problema doenca) throws Exception{
        if(doenca.getId() == null){
            Integer newId = Math.toIntExact(repository.count() + 1);
            doenca.setId(newId);
            return repository.save(doenca);
        } else{
             throw new Exception("Doença já registrada");
        }
    }

    public Problema registrarProblema(Integer id){
        return repository.findById(id).get();
    }

    public ProblemaDTO toDTO(Problema entity){
        ProblemaDTO dto = new ProblemaDTO();
        dto.setId(entity.getId());
        dto.setNomeDoProblema(entity.getNomeDoProblema());
        dto.setGrauDeUrgencia(entity.getGrauDeUrgencia());
        return dto;

    }

    public Problema toEntity(ProblemaDTO dto){
        Problema entity = new Problema();
        entity.setId(dto.getId());
        entity.setNomeDoProblema(dto.getNomeDoProblema());
        entity.setGrauDeUrgencia(dto.getGrauDeUrgencia());
        return entity;
    }

}

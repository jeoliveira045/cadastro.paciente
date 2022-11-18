package com.projeto.cadastro.paciente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.cadastro.paciente.dto.ClienteDTO;
import com.projeto.cadastro.paciente.entity.Cliente;
import com.projeto.cadastro.paciente.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ProblemaService problemaService;

    public ClienteDTO cadastrarCliente(ClienteDTO cliente0) throws Exception{
        Cliente entity = toEntity(cliente0);
        if(entity.getId() == null){
            Integer newId = Math.toIntExact(repository.count() + 1);
            entity.setId(newId);
            entity.setProblema(problemaService.registrarProblema(cliente0.getDoencaNumber()));
            repository.save(entity);
            return toDTO(entity);
        }
        else{
            throw new Exception("Cliente já cadastrado");
        }
    }

    public ClienteDTO toDTO(Cliente entity){
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setNomeDoPai(entity.getNomeDoPai());
        dto.setNomeDaMae(entity.getNomeDaMae());
        dto.setDoencaNumber(entity.getDoencaNumber());
        dto.setProblema(problemaService.toDTO(entity.getProblema()));
        return dto;
    }

    public Cliente toEntity(ClienteDTO dto){
        Cliente entity = new Cliente();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setNomeDoPai(dto.getNomeDoPai());
        entity.setNomeDaMae(dto.getNomeDaMae());
        entity.setDoencaNumber(dto.getDoencaNumber());
        entity.setProblema(problemaService.toEntity(dto.getProblema()));
        return entity;
    }

    public List<Cliente> listaDeEspera(){
        return repository.findAll();
    }
    public Cliente dadosDoCliente(Integer id){
        return repository.findById(id).get();
    }

    public void deletarById(Integer id){
        repository.deleteById(id);
    }

}

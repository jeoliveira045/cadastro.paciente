package com.projeto.cadastro.paciente.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.cadastro.paciente.dto.ClienteDTO;
import com.projeto.cadastro.paciente.entity.Cliente;
import com.projeto.cadastro.paciente.service.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteRestController {

    @Autowired
    ClienteService service;

    @PostMapping(value="/cadastrar-cliente")
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO cliente1) throws Exception{
         return ResponseEntity.ok().body(service.cadastrarCliente(cliente1));
    }

    @GetMapping(value="/lista-de-cadastrados")
    public ResponseEntity<List<ClienteDTO>> listaDeCadastrados(){
        return ResponseEntity.ok().body(service.listaDeCadastrados());
    }

    @GetMapping(value="{id}")
    public ResponseEntity<Cliente> dadosDoCliente(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.dadosDoCliente(id));
    }

    @PostMapping(value="/tirar-da-espera/{id}")
    public ResponseEntity<Void> deletarListaDeEspera(@PathVariable Integer id){
        service.deletarById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value="/lista-de-espera/{cpf}")
    public ResponseEntity<List<ClienteDTO>> listaDeEspera(@PathVariable Long cpf) throws Exception {
        return ResponseEntity.ok().body(service.listaDeEspera(cpf));
    }
    
}

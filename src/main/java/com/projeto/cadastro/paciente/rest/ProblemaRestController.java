package com.projeto.cadastro.paciente.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.cadastro.paciente.entity.Problema;
import com.projeto.cadastro.paciente.service.ProblemaService;

@RestController
@RequestMapping(value="/problema")
public class ProblemaRestController {
    @Autowired
    ProblemaService problemaService; 

    @PostMapping(value="adicionar-problema")
    public ResponseEntity<Problema> adicionarProblema(@RequestBody Problema problema)throws Exception{
        return ResponseEntity.ok().body(problemaService.adicionarProblema(problema));
    }

}
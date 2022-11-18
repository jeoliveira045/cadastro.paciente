package com.projeto.cadastro.paciente.dto;

import lombok.Data;

@Data
public class ProblemaDTO {
    private Integer id;
    private String nomeDoProblema;
    private String grauDeUrgencia;
}

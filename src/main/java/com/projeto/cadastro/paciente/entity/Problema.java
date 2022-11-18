package com.projeto.cadastro.paciente.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Problema {
    @Id
    private Integer id;
    private String nomeDoProblema;
    private String grauDeUrgencia;
}

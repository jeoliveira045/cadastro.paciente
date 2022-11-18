package com.projeto.cadastro.paciente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
// import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Cliente {
    @Id
    private Integer id;
    @Column(length=50)
    private String nome;
    @Column(length=50)
    private Long cpf;
    @Column(length=50)
    private String nomeDaMae;
    @Column(length=50)
    private String nomeDoPai;
    @Column(length=4)
    private Integer doencaNumber;
    @ManyToOne
    @JoinColumn(name="problema")
    private Problema problema;
}

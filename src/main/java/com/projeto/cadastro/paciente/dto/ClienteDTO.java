package com.projeto.cadastro.paciente.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Integer id;
    private String nome;
    private Long cpf;
    private String nomeDaMae;
    private String nomeDoPai;
    private Integer doencaNumber;
    private ProblemaDTO problema;
}

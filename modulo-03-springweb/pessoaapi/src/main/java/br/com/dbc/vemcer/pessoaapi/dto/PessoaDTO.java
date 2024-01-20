package br.com.dbc.vemcer.pessoaapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PessoaDTO {
    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
}

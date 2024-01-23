package br.com.dbc.vemcer.pessoaapi.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import java.time.LocalDate;
@Hidden
@Data

public class PessoaDTO {
    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
}

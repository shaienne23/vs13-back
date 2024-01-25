package br.com.dbc.vemcer.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data

public class PessoaDTO {
    private Integer idPessoa;
    @Schema(description = "Nome da Pessoa", required = true, example = "Shaienne")
    private String nome;
    @Schema(description = "Data de Nascimento", required = true, example = "1991-05-28")
    private LocalDate dataNascimento;
    @Schema(description = "Cpf Pessoa", required = true, example = "12387645603")
    private String cpf;
}

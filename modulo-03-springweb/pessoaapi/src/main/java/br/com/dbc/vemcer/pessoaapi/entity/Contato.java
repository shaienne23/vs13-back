package br.com.dbc.vemcer.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@RequiredArgsConstructor
@Data

public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    @NotNull(message = "Tipo de Contato não pode ser nulo")
    private TipoContato tipoContato;
    @Size(max = 13, message = "O numero deve ter no máximo 13 caracteres")
    @NotBlank(message = "Campo numero não pode ser nulo")
    private String numero;
    @NotEmpty(message = "Descrição não pode estar vazia ou nula!")
    private String descricao;
}
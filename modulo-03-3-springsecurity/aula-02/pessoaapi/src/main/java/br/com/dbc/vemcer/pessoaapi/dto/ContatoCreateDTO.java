package br.com.dbc.vemcer.pessoaapi.dto;

import br.com.dbc.vemcer.pessoaapi.entity.TipoContato;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {
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

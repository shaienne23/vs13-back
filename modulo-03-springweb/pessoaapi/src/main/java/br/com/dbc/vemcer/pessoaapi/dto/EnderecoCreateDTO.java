package br.com.dbc.vemcer.pessoaapi.dto;

import br.com.dbc.vemcer.pessoaapi.entity.TipoEndereco;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {
    private Integer idEndereco;
    private Integer idPessoa;
    @NotNull(message = "O Tipo de endereço não pode ser Nulo!")
    private TipoEndereco tipo;
    @Size(max = 250, message = "O Logradouro deve ter no máximo 250 caracteres")
    @NotEmpty(message = "Logradouro não pode estar vazio ou nulo!")
    private String logradouro;
    @NotNull(message = "O número não pode ser Nulo!")
    private Integer numero;
    private String complemento;
    @NotEmpty(message = "Campo CEP não pode ser vazio ou nulo")
    @Size(max = 8, message = "O CEP deve conter no maximo 8 caracteres")
    private String cep;
    @Size(max = 250, message = "A cidade deve ter no máximo 250 caracteres")
    @NotEmpty(message = "Cidade não pode ser vazio ou nulo!")
    private String cidade;
    @NotNull(message = "Estado não pode ser Nulo!")
    private String estado;
    @NotNull(message = "País não pode ser Nulo!")
    private String pais;
}

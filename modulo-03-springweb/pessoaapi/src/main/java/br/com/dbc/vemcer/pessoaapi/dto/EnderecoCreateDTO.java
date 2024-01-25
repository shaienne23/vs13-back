package br.com.dbc.vemcer.pessoaapi.dto;

import br.com.dbc.vemcer.pessoaapi.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {
    private Integer idEndereco;
    private Integer idPessoa;
    @NotNull(message = "O Tipo de endereço não pode ser Nulo!")
    @Schema(description = "Tipo de endereço", example = "Residencial")
    private TipoEndereco tipo;
    @Size(max = 250, message = "O Logradouro deve ter no máximo 250 caracteres")
    @Schema(description = "Nome Logradouro", example = "Rua Sao Paulo")
    @NotEmpty(message = "Logradouro não pode estar vazio ou nulo!")
    private String logradouro;
    @NotNull(message = "O número não pode ser Nulo!")
    @Schema(description = "Numero de endereço", example = "1")
    private Integer numero;
    @Schema(description = "Tipo de complemento", example = "prox praça")
    private String complemento;
    @NotEmpty(message = "Campo CEP não pode ser vazio ou nulo")
    @Schema(description = "Cep do endereço", example = "29175573")
    @Size(max = 8, message = "O CEP deve conter no maximo 8 caracteres")
    private String cep;
    @Size(max = 250, message = "A cidade deve ter no máximo 250 caracteres")
    @NotEmpty(message = "Cidade não pode ser vazio ou nulo!")
    @Schema(description = "Informar cidade", example = "Serra")
    private String cidade;
    @NotNull(message = "Estado não pode ser Nulo!")
    @Schema(description = "Nome Estado", example = "Estado")
    private String estado;
    @NotNull(message = "País não pode ser Nulo!")
    @Schema(description = "Nome Pais", example = "Brasil")
    private String pais;
}

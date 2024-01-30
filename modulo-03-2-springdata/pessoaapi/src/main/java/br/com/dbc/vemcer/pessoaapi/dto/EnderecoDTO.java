package br.com.dbc.vemcer.pessoaapi.dto;

import br.com.dbc.vemcer.pessoaapi.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EnderecoDTO {
    private Integer idEndereco;
    private Integer idPessoa;
    @Schema(description = "Tipo de endereço", example = "Residencial")
    private TipoEndereco tipo;
    @Schema(description = "Nome Logradouro", example = "Rua Sao Paulo")
    private String logradouro;
    @Schema(description = "Numero de endereço", example = "1")
    private Integer numero;
    @Schema(description = "Tipo de complemento", example = "prox praça")
    private String complemento;
    @Schema(description = "Cep do endereço", example = "29175573")
    private String cep;
    @Schema(description = "Informar cidade", example = "Serra")
    private String cidade;
    @Schema(description = "Nome Estado", example = "Estado")
    private String estado;
    @Schema(description = "Nome Pais", example = "Brasil")
    private String pais;
}

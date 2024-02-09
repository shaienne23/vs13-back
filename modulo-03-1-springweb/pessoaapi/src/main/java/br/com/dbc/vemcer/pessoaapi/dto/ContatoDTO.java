package br.com.dbc.vemcer.pessoaapi.dto;

import br.com.dbc.vemcer.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
public class ContatoDTO {

    private Integer idContato;
    private Integer idPessoa;
    @Schema(description = "Tipo de Contato", example = "Residencial")
    private TipoContato tipoContato;
    @Schema(description = "Informa numero", example = "997900000")
    private String numero;
    @Schema(description = "Informa descriçao contato", example = "telefone shay")
    private String descricao;
}

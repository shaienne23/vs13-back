package br.com.dbc.vemcer.pessoaapi.dto;

import br.com.dbc.vemcer.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
@Hidden
@Data
public class ContatoDTO {

    private Integer idContato;
    private Integer idPessoa;
    private TipoContato tipoContato;
    private String numero;
    private String descricao;
}

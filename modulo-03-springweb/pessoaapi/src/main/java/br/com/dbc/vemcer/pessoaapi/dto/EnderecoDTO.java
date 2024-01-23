package br.com.dbc.vemcer.pessoaapi.dto;

import br.com.dbc.vemcer.pessoaapi.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
@Hidden
@Data
public class EnderecoDTO {
    private Integer idEndereco;
    private Integer idPessoa;
    private TipoEndereco tipo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
}

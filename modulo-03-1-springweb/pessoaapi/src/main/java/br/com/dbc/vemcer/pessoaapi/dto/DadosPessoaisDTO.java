package br.com.dbc.vemcer.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoaisDTO {
    @Schema(description = "Campo Nome", required = true, example = "Ted Da Silva")
    private String nome;
    @Schema(description = "Campo CPF", required = true, example = "15187523320")
    private String cpf;
    @Schema(description = "Campo RG", required = true, example = "3416890")
    private String rg;
    @Schema(description = "Campo CNH", required = true, example = "1234560923")
    private String cnh;
    @Schema(description = "Campo Nome da Mãe", required = true, example = "Morena da Silva")
    private String nomeMae;
    @Schema(description = "Campo Nome do Pai", required = true, example = "Desconhecido")
    private String nomePai;
    @Schema(description = "Campo Titulo de Eleitor", required = true, example = "123543269087")
    private String tituloEleitor;
        @Schema(description = "Campo Sexo", required = true, example = "M")
    private Sexo sexo;
}

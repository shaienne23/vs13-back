package br.com.dbc.vemcer.pessoaapi.controller.interfaces;

import br.com.dbc.vemcer.pessoaapi.dto.DadosPessoaisDTO;
import feign.Param;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Dados Pessoais", description = "Endpoint de Dados Pessoais")
public interface IDadosPessoaisController {
    @Operation(summary = "Listar Dados pessoais", description = "Lista todas os dados pessoais do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de dados pessoais"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/dados-pessoais")
    public List<DadosPessoaisDTO> listDadosPessoais();
    @Operation(summary = "Listar Dados pessoais com filtro CPF", description = "Lista os dados pessoais com CPF filtrado no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de Dados pessoais por filtro"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/dados-pessoais/{cpf}")
    public DadosPessoaisDTO get(@PathVariable String cpf) throws Exception;
    @Operation(summary = "Criar de Dados Pessoais", description = "Cria novo Cadastro de dados pessoais.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna Dados Pessoais Cadastrados."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/dados-pessoais")
    public DadosPessoaisDTO criar(@Valid @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception;
    @Operation(summary = "Altera Dados Pessoais", description = "Altera Cadastro de dados pessoais por CPF.")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna Dados Pessoais Alterado."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("PUT /dados-pessoais/{cpf}")
    public DadosPessoaisDTO update(@Param("cpf") String cpf, DadosPessoaisDTO dadosPessoaisDTO) throws Exception;
    @Operation(summary = "Deleta Dados Pessoais", description = "Deleta Cadastro de Dados pessoais por cpf.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sem retorno, porem pessoa Deletada."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/dados-pessoais/{cpf}")
    public void delete(@Param("cpf") String cpf) ;

}

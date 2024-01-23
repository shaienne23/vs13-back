package br.com.dbc.vemcer.pessoaapi.controller.interfaces;

import br.com.dbc.vemcer.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface IEnderecoController {
    @Operation(summary = "Listar Endereços", description = "Lista todos os endereços do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listAll();

    @Operation(summary = "Listar Endereço por id", description = "Lista por id do endereço")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idEndereco}")
    public ResponseEntity<List<EnderecoDTO>>listByIdEndereco(@PathVariable("idEndereco") Integer id);

    @Operation(summary = "Lista Endereço por id Pessoa.", description = "Lista Endereço por id da pessoa.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna endereço por Id da Pessoa."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<EnderecoDTO>> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa);

    @Operation(summary = "Lista Endereço por descrição.", description = "Lista Endereço por filtro descrição.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna endereço por Id da Pessoa."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping ("/byname")
    public ResponseEntity<List<EnderecoDTO>> listByEstado(@RequestParam("estado") String estado);


    @Operation(summary = "Criar Endereço por id", description = "Cria Cadastro novo endereço para pessoa existente.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna Endereço Cadastrada."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                              @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception;

    @Operation(summary = "Altera Endereço por id", description = "Altera Cadastro de endereço por id.")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Altera Cadastro de endereço por id."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update( @PathVariable("idEndereco") Integer id,
                                               @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception;
    @Operation(summary = "Deleta Endereço", description = "Deleta Cadastro deendereço por id.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sem retorno, porem Endereço Deletado."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete (@PathVariable("idEndereco") Integer id) throws Exception;


}
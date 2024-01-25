package br.com.dbc.vemcer.pessoaapi.controller.interfaces;

import br.com.dbc.vemcer.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@Tag(name = "Dados Pessoa", description = "Endpoint de Dados de Pessoas")
public interface IPessoaController {
    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list();
    @Operation(summary = "Listar pessoas com filtro nome", description = "Lista as pessoas com nome filtrado no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping ("/byname")
    public ResponseEntity<List<PessoaDTO>>listByName(@RequestParam("nome") String nome);
    @Operation(summary = "Criar Pessoa", description = "Cria Cadastro nova pessoa.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna Pessoa Cadastrada."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception;
    @Operation(summary = "Altera Pessoa", description = "Altera Cadastro de pessoa por id.")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna Pessoa Alterada."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update( @PathVariable("idPessoa") Integer id,
                                             @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception;
    @Operation(summary = "Deleta Pessoa", description = "Deleta Cadastro de pessoa por id.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sem retorno, porem pessoa Deletada."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete (@PathVariable("idPessoa") Integer id) throws Exception;
    @Operation(summary = "Envia E-mail Pessoa", description = "Envia email para pessoa.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "E-mail enviado."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/email")
    public String email() throws Exception;
    @Operation(summary = "Teste Ambiente Propertie", description = "Testa Ambiente Local.")

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "E-mail enviado."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/ambiente")
    public String getAmbiente();
}
package br.com.dbc.vemcer.pessoaapi.controller.interfaces;

import br.com.dbc.vemcer.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface IContatoController {
    @Operation(summary = "Listar contatos", description = "Lista todos os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list();

    @Operation(summary = "Listar contatos com filtro descricao", description = "Lista os contatos com nome filtrado no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping ("/byname")
    public ResponseEntity<List<ContatoDTO>> listByName(@RequestParam("descricao") String descricao);

    @Operation(summary = "Criar Contato", description = "Cria Contato para pessoa.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna Contato Cadastrado."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    public ResponseEntity<ContatoDTO>create(@Valid @RequestBody ContatoCreateDTO contato)throws Exception;

    @Operation(summary = "Altera Contato", description = "Altera Cadastro de contato por id.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna contatos Alterado."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO>update( @PathVariable("idContato") Integer id,
                                             @Valid @RequestBody ContatoCreateDTO contatoAtualizar) throws Exception;
    @Operation(summary = "Deleta contato", description = "Deleta Cadastro de contatos por id.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sem retorno, porem contato Deletado."),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete (@PathVariable("idContato") Integer id) throws Exception;

}
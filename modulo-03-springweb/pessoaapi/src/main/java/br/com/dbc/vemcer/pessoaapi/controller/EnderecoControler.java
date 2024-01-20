package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.entity.Endereco;
import br.com.dbc.vemcer.pessoaapi.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@Validated
@RestController
@RequestMapping("/endereco")
public class EnderecoControler {
    private final EnderecoService enderecoService;

    public EnderecoControler(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> listAll() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> listByIdEndereco(@PathVariable("idEndereco") Integer id){
        return enderecoService.listByIdEndereco(id);
    }
    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa){
        return enderecoService.listByIdPessoa(idPessoa);

    }
    @GetMapping ("/byname")
    public List<Endereco> listByName(@RequestParam("estado") String estado){
        return enderecoService.listByName(estado);
    }

    @PostMapping ("/{idPessoa}")
    public ResponseEntity<Endereco> create( @PathVariable("idPessoa") Integer idPessoa,
                            @Valid @RequestBody Endereco endereco)throws Exception{
        log.info("Criando Endereço");
        enderecoService.create(idPessoa, endereco);
        log.info("Endereço Criado!");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update( @PathVariable("idEndereco") Integer id,
                          @Valid @RequestBody Endereco enderecoAtualizar) throws Exception{
        log.info("Alterando Endereço");
        enderecoService.update(id, enderecoAtualizar);
        log.info("Criando Endereço!");
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete (@PathVariable("idEndereco") Integer id) throws Exception{
        log.info("Deletando Endereço");
        enderecoService.delete(id);
        log.info("Endereço Deletado!");
        return ResponseEntity.ok().build();
    }
}

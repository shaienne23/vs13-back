package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import br.com.dbc.vemcer.pessoaapi.service.PessoaService;
import lombok.Value;
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
@RequestMapping("/pessoa")
public class PessoaControler {

    private final PessoaService pessoaService;

    public PessoaControler(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @GetMapping("/hello")
    public String hello(){
        log.trace("A TRACE Message");
        log.warn("A WARN Message");
               return "Hello WORLD!\n" + " <br>App:   <br>Usuario: " + log.isErrorEnabled();
    }

    @GetMapping("/hello2")
    public String hello2(){
        return "Hello World 2!";
    }

    @GetMapping
    public List<Pessoa> list() {

        return pessoaService.list();
    }

    @GetMapping ("/byname")
    public List<Pessoa> listByName(@RequestParam("nome") String nome){
        return pessoaService.listByName(nome);
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa) throws Exception {
        log.info("Criando Pessoa");
        pessoaService.create(pessoa);
        log.info("Pessoa Criada");
        return new ResponseEntity<>(HttpStatus.OK) ;
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> update( @PathVariable("idPessoa") Integer id,
                          @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception{
        log.info("Alterando Pessoa");
        pessoaService.update(id, pessoaAtualizar);
        log.info("Pessoa Alterada!");
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete (@PathVariable("idPessoa") Integer id) throws Exception{
        log.info("Deletando Pessoa");
        pessoaService.delete(id);
        log.info("Pessoa Deletada");
        return ResponseEntity.ok().build();
    }
}

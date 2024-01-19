package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import br.com.dbc.vemcer.pessoaapi.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        return "Hello World!";
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
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.OK) ;
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> update( @PathVariable("idPessoa") Integer id,
                          @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception{
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.OK);
    }
    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete (@PathVariable("idPessoa") Integer id) throws Exception{
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }
}

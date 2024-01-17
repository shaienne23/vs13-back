package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import br.com.dbc.vemcer.pessoaapi.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaControler {
    private PessoaService pessoaService;

    public PessoaControler(){
        pessoaService = new PessoaService();
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
    public Pessoa create(@RequestBody Pessoa pessoa){
        return pessoaService.create(pessoa);
    }

    @PutMapping("/{idPessoa}")
    public Pessoa update( @PathVariable("idPessoa") Integer id,
                          @RequestBody Pessoa pessoaAtualizar) throws Exception{
        return pessoaService.update(id, pessoaAtualizar);
    }
    @DeleteMapping("/{idPessoa}")
    public void delete (@PathVariable("idPessoa") Integer id) throws Exception{
        pessoaService.delete(id);
    }
}

package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.entity.Contato;
import br.com.dbc.vemcer.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemcer.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoControler {
    private ContatoService contatoService;

    // Criei uma instancia de PessoaRepository e depois utilizei para criar uma instancia de contatoservice.
    // pois meus resultados estavam vindo triplicados.
    public ContatoControler() {
        PessoaRepository pessoaRepository = new PessoaRepository();
        contatoService = new ContatoService(pessoaRepository);
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping ("/byname")
    public List<Contato> listByName(@RequestParam("descricao") String descricao){
        return contatoService.listByName(descricao);
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato){
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}")
    public Contato update( @PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizar) throws Exception{
        return contatoService.update(id, contatoAtualizar);
    }
    @DeleteMapping("/{idContato}")
    public void delete (@PathVariable("idContato") Integer id) throws Exception{
        contatoService.delete(id);
    }
}

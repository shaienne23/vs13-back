package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.entity.Contato;
import br.com.dbc.vemcer.pessoaapi.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/contato")
public class ContatoControler {
    private final ContatoService contatoService;

    public ContatoControler(ContatoService contatoService) {
        this.contatoService = contatoService;
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
    public ResponseEntity<Contato>create(@Valid @RequestBody Contato contato)throws Exception{
        return new ResponseEntity<>(contatoService.create(contato), HttpStatus.OK);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato>update( @PathVariable("idContato") Integer id,
                          @Valid @RequestBody Contato contatoAtualizar) throws Exception{
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizar), HttpStatus.OK);
    }
    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete (@PathVariable("idContato") Integer id) throws Exception{
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }
}

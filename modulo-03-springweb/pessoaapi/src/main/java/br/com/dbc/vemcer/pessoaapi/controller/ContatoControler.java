package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.entity.Contato;
import br.com.dbc.vemcer.pessoaapi.service.ContatoService;
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
        log.info("Criando Contato. ");
        contatoService.create(contato);
        log.info("Contato Criado!");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato>update( @PathVariable("idContato") Integer id,
                          @Valid @RequestBody Contato contatoAtualizar) throws Exception{
    log.info("Alterando Contato.");
        contatoService.update(id, contatoAtualizar);
        log.info("Contato Atualizado!");
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete (@PathVariable("idContato") Integer id) throws Exception{
        log.info("Deletando Contato.");
        contatoService.delete(id);
        log.info("Contato Deletado!");
        return ResponseEntity.ok().build();
    }
}

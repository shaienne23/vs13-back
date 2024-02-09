package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.controller.interfaces.IContatoController;
import br.com.dbc.vemcer.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemcer.pessoaapi.service.ContatoService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@RequestMapping("/contato")

public class ContatoControler implements IContatoController {
    private final ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list() {
        log.info("Listando Contatos.");
        List<ContatoDTO> contatosListados = contatoService.list();
        return new ResponseEntity<>(contatosListados, HttpStatus.OK);
    }
    @GetMapping ("/byname")
    public ResponseEntity<List<ContatoDTO>> listByName(@RequestParam("descricao") String descricao){
        log.info("Listando Contato ByName");
        List<ContatoDTO> contatosListadoName = contatoService.listByName(descricao);
        return new ResponseEntity<>(contatosListadoName, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ContatoDTO>create(@Valid @RequestBody ContatoCreateDTO contato)throws Exception{
        log.info("Criando Contato. ");
        ContatoDTO contatoDTO = contatoService.create(contato);
        log.info("Contato Criado!");
        return new ResponseEntity<>(contatoDTO, HttpStatus.OK);
    }
    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO>update( @PathVariable("idContato") Integer id,
                          @Valid @RequestBody ContatoCreateDTO contatoAtualizar) throws Exception{
        log.info("Alterando Contato.");
        ContatoDTO contatoAtualizado = contatoService.update(id, contatoAtualizar);
        log.info("Contato Atualizado!");
        return new ResponseEntity<>(contatoAtualizado, HttpStatus.OK);
    }
    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete (@PathVariable("idContato") Integer id) throws Exception{
        log.info("Deletando Contato.");
        contatoService.delete(id);
        log.info("Contato Deletado!");
        return ResponseEntity.ok().build();
    }
}

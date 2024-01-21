package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemcer.pessoaapi.service.PessoaService;
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
    public ResponseEntity<List<PessoaDTO>> list() {
        log.info("Listando Pessoa");
        List<PessoaDTO> pessoasListadas = pessoaService.list();
        log.info("Pessoas Listadas");

        return new ResponseEntity<>(pessoasListadas, HttpStatus.OK);
    }

    @GetMapping ("/byname")
    public ResponseEntity<List<PessoaDTO>>listByName(@RequestParam("nome") String nome){
        log.info("Listando Pessoa byname");
        List<PessoaDTO> pessoasListadas = pessoaService.listByName(nome);
        log.info("Pessoas byname Listadas");

        return new ResponseEntity<>(pessoasListadas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        log.info("Criando Pessoa");
        PessoaDTO pessoaCriada = pessoaService.create(pessoa);
        log.info("Pessoa Criada");
        return new ResponseEntity<>(pessoaCriada, HttpStatus.OK) ;
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update( @PathVariable("idPessoa") Integer id,
                          @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception{
        log.info("Alterando Pessoa");
        PessoaDTO pessoaAlterada = pessoaService.update(id, pessoaAtualizar);
        log.info("Pessoa Alterada!");
        return new ResponseEntity<>(pessoaAlterada, HttpStatus.OK);
    }
    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete (@PathVariable("idPessoa") Integer id) throws Exception{
        log.info("Deletando Pessoa");
        pessoaService.delete(id);
        log.info("Pessoa Deletada");
        return ResponseEntity.ok().build();
    }
}

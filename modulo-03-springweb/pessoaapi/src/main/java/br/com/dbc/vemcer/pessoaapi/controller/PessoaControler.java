package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.config.PropertiesReader;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemcer.pessoaapi.service.EmailService;
import br.com.dbc.vemcer.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
@Validated
@Slf4j
@Component





public class PessoaControler {

    private final PessoaService pessoaService;
    private final PropertiesReader propertiesReader;
    private final EmailService emailService;

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

        String content = emailService.geContentFromTemplate("POST", "PESSOA", pessoaCriada.getIdPessoa());
        emailService.sendEmail(content);

        return new ResponseEntity<>(pessoaCriada, HttpStatus.OK) ;
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update( @PathVariable("idPessoa") Integer id,
                          @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception{
        log.info("Alterando Pessoa");
        PessoaDTO pessoaAlterada = pessoaService.update(id, pessoaAtualizar);
        log.info("Pessoa Alterada!");

        String content = emailService.geContentFromTemplate( "PUT","PESSOA", pessoaAlterada.getIdPessoa());
        emailService.sendEmail(content);

        return new ResponseEntity<>(pessoaAlterada, HttpStatus.OK);
    }
    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete (@PathVariable("idPessoa") Integer id) throws Exception{
        log.info("Deletando Pessoa");
        pessoaService.delete(id);
        log.info("Pessoa Deletada");
        String content = emailService.geContentFromTemplate(
                "DELETE","PESSOA", null);
        emailService.sendEmail(content);
        return ResponseEntity.ok().build();
    }
    @Value("${spring.application.name}")
    private String app;
    @GetMapping("/ambiente")

    public String getAmbiente() {
        log.info("Enviando ambiente Pessoa");
        return propertiesReader.getAmbiente();

    }

    @GetMapping("/email")
    public String email() throws Exception {
        log.info("Enviando email Pessoa");
        //emailService.sendSimpleMessage();
        //emailService.sendWithAttachment();

        String content = emailService.geContentFromTemplate( "GET", "PESSOA", null);
        emailService.sendEmail(content);

        log.info("E-mail enviado!");
        return "E-mail enviado pela " + app + "!";

}}

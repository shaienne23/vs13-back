package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.config.PropertiesReader;
import br.com.dbc.vemcer.pessoaapi.controller.interfaces.IPessoaController;
import br.com.dbc.vemcer.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaCompletaDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import br.com.dbc.vemcer.pessoaapi.service.EmailService;
import br.com.dbc.vemcer.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
@Validated
@Slf4j
@Component

public class PessoaControler implements IPessoaController {

    private final PessoaService pessoaService;
    private final PropertiesReader propertiesReader;
    private final EmailService emailService;


    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list() {
        log.info("Listando Pessoa");
        List<PessoaDTO> pessoasListadas = pessoaService.list();
        log.info("Pessoas Listadas");

        return new ResponseEntity<>(pessoasListadas, HttpStatus.OK);
    }

    @GetMapping ("/byname/nome")
    public ResponseEntity<List<PessoaDTO>>listByName(@RequestParam("nome") String nome){
        log.info("Listando Pessoa byname");
        List<PessoaDTO> pessoasListadas = pessoaService.findByNomeContainingIgnoreCase(nome);
        log.info("Pessoas byname Listadas");

        return new ResponseEntity<>(pessoasListadas, HttpStatus.OK);
    }
    @GetMapping("/bycpf/cpf")
    public ResponseEntity<List<PessoaDTO>> listByCpf(@RequestParam("cpf") String cpf) {
        log.info("Listando Pessoas por CPF");
        List<PessoaDTO> pessoasListadas = pessoaService.findByCpf(cpf);
        log.info("Pessoas por CPF listadas com sucesso");
        return new ResponseEntity<>(pessoasListadas, HttpStatus.OK);
    }

    @GetMapping("/bydate/data")
    public ResponseEntity<List<PessoaDTO>> listByDate(
            @RequestParam("dataInicial") LocalDate dataInicial,
            @RequestParam("dataFinal") LocalDate dataFinal) {
        log.info("Listando Pessoas por data de nascimento");
        List<PessoaDTO> pessoasListadas = pessoaService.findByDataNascimentoBetween(dataInicial, dataFinal);
        log.info("Pessoas por data de nascimento listadas com sucesso");
        return new ResponseEntity<>(pessoasListadas, HttpStatus.OK);
    }

    @Value("${spring.mail.username}")
    private String email;
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
    }

        @GetMapping("/completo")
        public ResponseEntity<List<PessoaCompletaDTO>> getPessoaCompleto(@RequestParam(name = "id", required = false) Integer idPessoa) {
            log.info("Listando Pessoa Completa");
            List<PessoaCompletaDTO> pessoasListadas = pessoaService.getPessoaCompleto( idPessoa);
            log.info("Pessoa Completa listada com sucesso");
            return new ResponseEntity<>(pessoasListadas, HttpStatus.OK);
        }

    }

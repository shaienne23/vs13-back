package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.config.PropertiesReader;
import br.com.dbc.vemcer.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemcer.pessoaapi.service.EmailService;
import br.com.dbc.vemcer.pessoaapi.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
@Slf4j
@Component

@RequestMapping("/endereco")
public class EnderecoControler {
    private final EnderecoService enderecoService;

    private final PropertiesReader propertiesReader;
    private final EmailService emailService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listAll() {
        log.info("Listando Endereço.");
        List<EnderecoDTO> enderecosListados = enderecoService.list();
        return new ResponseEntity<>(enderecosListados, HttpStatus.OK);
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<List<EnderecoDTO>>listByIdEndereco(@PathVariable("idEndereco") Integer id){
        log.info("Listando endereços por Id.");
        List<EnderecoDTO> enderecosListados = enderecoService.listByIdEndereco(id);
        return new ResponseEntity<>(enderecosListados, HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<EnderecoDTO>> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa){
        log.info("Listando endereços por idPessoa.");
        List<EnderecoDTO> enderecosListadosId = enderecoService.listByIdPessoa(idPessoa);
        return new ResponseEntity<>(enderecosListadosId, HttpStatus.OK);
    }
    @GetMapping ("/byname")
    public ResponseEntity<List<EnderecoDTO>> listByEstado(@RequestParam("estado") String estado){
        log.info("Listando endereços por Estado.");
        List<EnderecoDTO> enderecoPorEstado = enderecoService.listByEstado(estado);
        return new ResponseEntity<>(enderecoPorEstado, HttpStatus.OK);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                              @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        log.info("Criando Endereço");
        EnderecoDTO enderecoCriado = enderecoService.create(idPessoa, endereco);
        log.info("Endereço Criado!");

        String contentEndereco = emailService.geContentFromTemplate("POST", "ENDERECO");
        emailService.sendEmail(contentEndereco);

        return new ResponseEntity<>(enderecoCriado, HttpStatus.OK);
    }


    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update( @PathVariable("idEndereco") Integer id,
                          @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception{
        log.info("Alterando Endereço");
        EnderecoDTO enderecoParaAtualizar = enderecoService.update(id, enderecoAtualizar);
        log.info("Endereço Alterado!");

        String contentEndereco = emailService.geContentFromTemplate("PUT", "ENDERECO");
        emailService.sendEmail(contentEndereco);

        return new ResponseEntity<>(enderecoParaAtualizar, HttpStatus.OK);
    }
    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete (@PathVariable("idEndereco") Integer id) throws Exception{
        log.info("Deletando Endereço");
        enderecoService.delete(id);
        log.info("Endereço Deletado!");

        String contentEndereco = emailService.geContentFromTemplate("DELETE", "ENDERECO");
        emailService.sendEmail(contentEndereco);

        return ResponseEntity.ok().build();
    }
}

package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemcer.pessoaapi.controller.interfaces.IDadosPessoaisController;
import br.com.dbc.vemcer.pessoaapi.dto.DadosPessoaisDTO;
import feign.Param;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@Validated
@Slf4j
@RequiredArgsConstructor
@RestController

@RequestMapping("/dados-pessoais")
public class DadosPessoaisController implements IDadosPessoaisController {
    private final DadosPessoaisClient cliente;
    @GetMapping("/dados-pessoais")
    public List<DadosPessoaisDTO> listDadosPessoais() {
        return cliente.getAll();
    }
    @GetMapping("/dados-pessoais/{cpf}")
    public DadosPessoaisDTO get(@PathVariable String cpf) throws Exception {
        log.info("Listando dados Pessoais por CPF.");
        return cliente.get(cpf);
    }
    @PostMapping("/dados-pessoais")
    public DadosPessoaisDTO criar(
            @Valid @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        log.info("Criando Dados Pessoais");
        return cliente.post(dadosPessoaisDTO);
    }
    @PutMapping("/dados-pessoais/{cpf}")
    public DadosPessoaisDTO update(
            @Param("cpf") String cpf, DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        log.info("Alterando dados Pessoais");
        return cliente.put(cpf, dadosPessoaisDTO);
    }
    @DeleteMapping("/dados-pessoais/{cpf}")
    public void delete(@Param("cpf") String cpf) {
        log.info("Deletando Dados Pessoais");
        cliente.delete(cpf);
    }
}
package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemcer.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Param;
import feign.RequestLine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Validated
@Slf4j
@RequiredArgsConstructor
@RestController

public class DadosPessoaisService {
    private final DadosPessoaisClient cliente;
    private final ObjectMapper objectMapper;

    public List<DadosPessoaisDTO> listDadosPessoais() {
        List<DadosPessoaisDTO> dados = cliente.getAll();

        return dados.stream()
                .map(dadosPessoaisDTO -> objectMapper.convertValue(dadosPessoaisDTO, DadosPessoaisDTO.class))
                .collect(Collectors.toList());
    }
    public List<DadosPessoaisDTO> get(String cpf) throws Exception {
        List<DadosPessoaisDTO> dados = (List<DadosPessoaisDTO>) cliente.get(cpf);

        return dados.stream()
                .map(dadosPessoaisDTO -> objectMapper.convertValue(dadosPessoaisDTO, DadosPessoaisDTO.class))
                .collect(Collectors.toList());
    }
    public DadosPessoaisDTO criar(DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        DadosPessoaisDTO dados = objectMapper.convertValue(dadosPessoaisDTO, DadosPessoaisDTO.class);
        DadosPessoaisDTO resultado = cliente.post(dados);
      return resultado;
    }
    public DadosPessoaisDTO update(String cpf, DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        DadosPessoaisDTO dadosParaAtualizar = objectMapper.convertValue(dadosPessoaisDTO, DadosPessoaisDTO.class);
        DadosPessoaisDTO resultado = cliente.put(cpf, dadosParaAtualizar);
        DadosPessoaisDTO dadosPessoaisAtualizados = objectMapper.convertValue(resultado, DadosPessoaisDTO.class);
        return dadosPessoaisAtualizados;
    }
    public DadosPessoaisDTO delete(String cpf) throws Exception{
        DadosPessoaisDTO dados = cliente.delete(cpf);
        return dados;
    }
}
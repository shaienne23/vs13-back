package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemcer.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class PessoaService {
private final PessoaRepository pessoaRepository;
private final ObjectMapper objectMapper;

    public List<PessoaDTO> list() {
        log.info("Listando Pessoa na camada  Service");
        List<Pessoa> pessoas = pessoaRepository.list();

        return pessoas.stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }
    public List<PessoaDTO> listByName(String nome){
        log.info("Listando Pessoa na camada  Service ByName");
        List<Pessoa> pessoas = pessoaRepository.listByName(nome);

        return pessoas.stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO)throws Exception{
        log.info("Criando Pessoa na camada  Service");
        Pessoa pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, Pessoa.class);
        pessoaEntity = pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

        return pessoaDTO;
        }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Atualizando Pessoa na camada Service");
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        return objectMapper.convertValue(pessoaRepository.update(id, pessoaRecuperada), PessoaDTO.class);
    }

    public void delete(Integer id) throws Exception{
        log.info("Deletando Pessoa na camada Service");
     Pessoa pessoaRecuperada = getPessoa(id);
     pessoaRepository.delete(pessoaRecuperada);
}
    private Pessoa getPessoa(Integer id) throws Exception{
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
            .filter(pessoa -> pessoa.getIdPessoa().equals(id))
            .findFirst()
            .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
     return pessoaRecuperada;
}
    public Pessoa findById(Integer id) throws Exception{
        return getPessoa(id);
    }
}

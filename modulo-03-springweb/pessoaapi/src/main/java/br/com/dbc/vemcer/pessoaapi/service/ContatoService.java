package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemcer.pessoaapi.entity.Contato;
import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemcer.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ContatoService {
private final ContatoRepository contatoRepository;
private final ObjectMapper objectMapper;

    public List<ContatoDTO> list() {
        List<Contato> contatos = contatoRepository.list();
    return contatos.stream()
            .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
            .collect(Collectors.toList());
    }
    public List<ContatoDTO> listByName(String descricao){
        List<Contato> contatos = contatoRepository.listByName(descricao);

        return contatos.stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }
    public ContatoDTO create(ContatoCreateDTO contatoCreateDTO)throws Exception{
        Contato contatoEntity = objectMapper.convertValue(contatoCreateDTO, Contato.class);
        contatoEntity = contatoRepository.create(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
    }
    public ContatoDTO update( Integer id, ContatoCreateDTO contatoAtualizar) throws Exception{
        ContatoCreateDTO contatoAtualizado = contatoRepository.update(id, contatoAtualizar);
        return objectMapper.convertValue(contatoAtualizado, ContatoDTO.class);
    }
    public void delete(Integer id) throws Exception{
        Contato contatoRecuperado = getContato(id);
        contatoRepository.delete(contatoRecuperado);
    }
    private Contato getContato(Integer id) throws Exception{
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(pessoa -> pessoa.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() ->  new RegraDeNegocioException("Contato não encontrado!"));
        return contatoRecuperado;
    }
    }

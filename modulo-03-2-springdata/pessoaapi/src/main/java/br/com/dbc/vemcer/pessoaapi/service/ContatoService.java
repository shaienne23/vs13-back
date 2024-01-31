package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemcer.pessoaapi.entity.Contato;
import br.com.dbc.vemcer.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemcer.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

    @RequiredArgsConstructor
    @Service
    @Slf4j
    public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final ObjectMapper objectMapper;
        private static final Logger logger = LoggerFactory.getLogger(ContatoService.class);
    private final String NOT_FOUND_MESSAGE = "ID de contato nao encontrado";

        public List<ContatoDTO> list() {
            return contatoRepository.findAll().stream()
                    .map(this::retornarDTO)
                    .collect(Collectors.toList());
        }
        public List<ContatoDTO> findAllByDescricaoContains(String descricao) {
            return contatoRepository.findAllByDescricaoContains(descricao).stream()
                    .map(this::retornarDTO)
                    .collect(Collectors.toList());
        }
        public ContatoDTO create(ContatoCreateDTO contato) {
            Contato contatoEntity = converterDTO(contato);
            return retornarDTO(contatoRepository.save(contatoEntity));
        }

        public ContatoDTO update(Integer id, ContatoCreateDTO contatoDto) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
            Contato contatoEntityRecuperada = returnContatoById(id);

            contatoEntityRecuperada.setTipoContato(contatoDto.getTipoContato());
            contatoEntityRecuperada.setDescricao(contatoDto.getDescricao());
            contatoEntityRecuperada.setNumero(contatoDto.getNumero());

            return retornarDTO(contatoRepository.save(contatoEntityRecuperada));
        }

        public void delete(Integer id) {
            try {
                Contato contatoEntityRecuperada = returnContatoById(id);
                contatoRepository.delete(contatoEntityRecuperada);
            } catch (EntidadeNaoEncontradaException ex){
                ex.printStackTrace();
            }
        }
    public Contato returnContatoById(Integer id) throws EntidadeNaoEncontradaException {
       return contatoRepository.findById(id)
            .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
        }

    public Contato converterDTO(ContatoCreateDTO dto) {
        return objectMapper.convertValue(dto, Contato.class);
    }
    public ContatoDTO retornarDTO(Contato entity) {
        return objectMapper.convertValue(entity, ContatoDTO.class);
    }
    }

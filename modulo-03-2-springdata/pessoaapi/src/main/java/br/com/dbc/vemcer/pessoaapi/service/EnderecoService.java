package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.dto.*;
import br.com.dbc.vemcer.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemcer.pessoaapi.entity.*;
import br.com.dbc.vemcer.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemcer.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
@Slf4j
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    private final String NOT_FOUND_MESSAGE = "ID de endereço nao encontrado";

    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }
    public List<EnderecoDTO> findAllByEstadoContains(String estado){
        List<Endereco> enderecos = enderecoRepository.findAllByEstadoContains(estado);

        return enderecos.stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByIdEndereco(Integer id) {
        List<Endereco> enderecos = enderecoRepository.findAllByIdEnderecoContains(id);
        return enderecos.stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }
    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
        List<Endereco> enderecos = enderecoRepository.listByIdPessoa(idPessoa);

        return enderecos.stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO create(EnderecoCreateDTO endereco) {
        Endereco enderecoEntity = converterDTO(endereco);
        return retornarDTO(enderecoRepository.save(enderecoEntity));
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoDto) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        Endereco enderecoEntityRecuperada = returnEnderecoById(id);

        enderecoEntityRecuperada.setCep(enderecoDto.getCep());
        enderecoEntityRecuperada.setNumero(enderecoDto.getNumero());
        enderecoEntityRecuperada.setCidade(enderecoDto.getCidade());
        enderecoEntityRecuperada.setEstado(enderecoDto.getEstado());
        enderecoEntityRecuperada.setComplemento(enderecoDto.getComplemento());
        enderecoEntityRecuperada.setLogradouro(enderecoDto.getLogradouro());
        enderecoEntityRecuperada.setPais(enderecoDto.getPais());
        enderecoEntityRecuperada.setTipo(enderecoDto.getTipo());

        return retornarDTO(enderecoRepository.save(enderecoEntityRecuperada));
    }

    public void delete(Integer id) {
        try {
            Endereco enderecoEntityRecuperada = returnEnderecoById(id);
            enderecoRepository.delete(enderecoEntityRecuperada);
        } catch (EntidadeNaoEncontradaException ex){
            ex.printStackTrace();
        }
    }
    public Endereco returnEnderecoById(Integer id) throws EntidadeNaoEncontradaException {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }
    public Endereco converterDTO(EnderecoCreateDTO dto) {
        return objectMapper.convertValue(dto, Endereco.class);
    }
    public EnderecoDTO retornarDTO(Endereco entity) {
        return objectMapper.convertValue(entity, EnderecoDTO.class);
    }
}

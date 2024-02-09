package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemcer.pessoaapi.entity.Endereco;
import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
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
    public List<EnderecoDTO> list() {
        List<Endereco> enderecos = enderecoRepository.list();

        return enderecos.stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
    public List<EnderecoDTO> listByIdEndereco(Integer id) {
        List<Endereco> enderecos = enderecoRepository.listByIdEndereco(id);

        return enderecos.stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
        List<Endereco> enderecos = enderecoRepository.listByIdPessoa(idPessoa);

        return enderecos.stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
    public List<EnderecoDTO> listByEstado(String estado){
        List<Endereco> enderecos = enderecoRepository.listByEstado(estado);

        return enderecos.stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoCreateDTO)throws Exception{
        Pessoa pessoa = pessoaService.findById(idPessoa);
        Endereco enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
        enderecoEntity = EnderecoRepository.create(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);

        return enderecoDTO;
    }
    public EnderecoDTO update(Integer idPessoa, EnderecoCreateDTO enderecoAtualizar) throws Exception {
        EnderecoCreateDTO enderecoAtualizado = enderecoRepository.update(idPessoa, enderecoAtualizar);
        return objectMapper.convertValue(enderecoAtualizado, EnderecoDTO.class);
    }
    public void delete(Integer id) throws Exception{
        Endereco enderecoRecuperado = getEndereco(id);
        enderecoRepository.delete(enderecoRecuperado);
    }
    private Endereco getEndereco(Integer id) throws Exception {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() ->  new RegraDeNegocioException("Endereço não encontrado!"));
    }
}

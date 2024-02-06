package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.dto.PessoaCompletaDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import br.com.dbc.vemcer.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemcer.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class PessoaService {
private final PessoaRepository pessoaRepository;
private final ObjectMapper objectMapper;

private final String NOT_FOUND_MESSAGE = "ID da pessoa nao encontrada";

    public Pessoa returnPersonById(Integer id) throws EntidadeNaoEncontradaException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }
    public List<PessoaDTO> findByNomeContainingIgnoreCase(String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome).stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<PessoaDTO>findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf).stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }
    public List<PessoaDTO> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal) {
        List<Pessoa> pessoasEncontradas = pessoaRepository.findByDataNascimentoBetween(dataInicial, dataFinal);
        return pessoasEncontradas.stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }
    public PessoaDTO create(PessoaCreateDTO pessoa) {
        Pessoa pessoaEntity = converterDTO(pessoa);
        return retornarDTO(pessoaRepository.save(pessoaEntity));
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaDto) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        Pessoa pessoaEntityRecuperada = returnPersonById(id);

        pessoaEntityRecuperada.setCpf(pessoaDto.getCpf());
        pessoaEntityRecuperada.setDataNascimento(pessoaDto.getDataNascimento());
        pessoaEntityRecuperada.setNome(pessoaDto.getNome());

        return retornarDTO(pessoaRepository.save(pessoaEntityRecuperada));
    }

    public void delete(Integer id) {
        try {
            Pessoa pessoaEntityRecuperada = returnPersonById(id);
            pessoaRepository.delete(pessoaEntityRecuperada);
        } catch (EntidadeNaoEncontradaException ex){
            ex.printStackTrace();
        }
    }

//    optional
//    public Optional<List<PessoaEnderecoDto>> listWithAddress(Integer idPessoa) {
//        return Optional.ofNullable(idPessoa)
//                .flatMap(pessoaRepository::findById)
//                .map(pessoaEntity -> {
//                    PessoaEnderecoDto pessoaEnderecoDto = objectMapper.convertValue(pessoaEntity, PessoaEnderecoDto.class);
//                    pessoaEnderecoDto.setEnderecos(pessoaEntity.getEnderecos());
//                    return Collections.singletonList(pessoaEnderecoDto);
//                })
//                .or(() -> Optional.of(
//                        pessoaRepository.findAll().stream()
//                               List .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaEnderecoDto.class))
////                                .collect(Collectors.to())
//                ));
//    }
    public List<PessoaCompletaDTO> getPessoaCompleto(Integer idPessoa) {
        List<Pessoa> resultados = pessoaRepository.findPessoaCompleta(idPessoa);

        return resultados.stream()
                .map(result -> objectMapper.convertValue(result, PessoaCompletaDTO.class))
                .collect(Collectors.toList());
    }

    public Pessoa converterDTO(PessoaCreateDTO dto) {
        return objectMapper.convertValue(dto, Pessoa.class);
    }
    public PessoaDTO retornarDTO(Pessoa entity) {
        return objectMapper.convertValue(entity, PessoaDTO.class);
    }
//    public static PessoaCompletaDTO pessoaToPessoaCompletaDTO(Pessoa pessoa){
//        PessoaCompletaDTO pessoaCompletaDTO = new PessoaCompletaDTO();
//        pessoaCompletaDTO.setIdPessoa(pessoa.getIdPessoa());
//        pessoaCompletaDTO.setNome(pessoa.getNome());
//        pessoaCompletaDTO.setEmail(pessoa.getEmail());
//        pessoaCompletaDTO.setDataNascimento(pessoa.getDataNascimento());
//        pessoaCompletaDTO.setCpf(pessoa.getCpf());
//        for (Contato contato : pessoa.getContatos()) (
//                pessoaCompletaDTO.getContatos().add(ContatoMapper.contatoEntityToContatoCompletoResponseDto(contato));
//
//        for (Endereco endereco : pessoa.getEnderecos()) (
//                pessoaCompletaDTO.getEnderecos() .add(EnderecoMapper.enderecoEntityToEnderecoCompletoResponseDto(endereco));
//
//        if (pessoa.getPet() != null) 4
//        pessoaCompletaDTO.setPet (PetMapper.petEntityToPetCompletoResponseDto(pessoa.getPet()));
//
//        return pessoaCompletaDTO;
//    }
}

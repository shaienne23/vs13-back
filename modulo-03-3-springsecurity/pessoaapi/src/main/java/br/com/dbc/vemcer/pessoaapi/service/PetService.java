package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.dto.*;
import br.com.dbc.vemcer.pessoaapi.entity.Endereco;
import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import br.com.dbc.vemcer.pessoaapi.entity.Pet;
import br.com.dbc.vemcer.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemcer.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class PetService {
private final PetRepository petRepository;
private final PessoaService pessoaService;
private final ObjectMapper objectMapper;

private final String NOT_FOUND_MESSAGE = "ID da pessoa não encontrada";


    public List<PetDTO> list() {
        return petRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }
    public PetDTO create(PetCreateDTO petCreateDTO) throws Exception{
        Pessoa pessoa = pessoaService.returnPersonById(petCreateDTO.getIdPessoa());

        Pet pet = converterDTO(petCreateDTO);
        pet.setPessoa(pessoa);

            return objectMapper.convertValue(petRepository.save(pet), PetDTO.class);
}

//public PetDTO update(Integer id, PetCreateDTO petAlterado) throws Exception{
//        Pessoa pessoa = pessoaService.returnPersonById(petAlterado.getIdPessoa());
//
//        pessoa.setPets(petAlterado.getPessoa().getPets());
//       return retornarDTO(petRepository.save(petAlterado));
//}

//    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaDto) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
//        Pessoa pessoaEntityRecuperada = returnPersonById(id);
//
//        pessoaEntityRecuperada.setCpf(pessoaDto.getCpf());
//        pessoaEntityRecuperada.setDataNascimento(pessoaDto.getDataNascimento());
//        pessoaEntityRecuperada.setNome(pessoaDto.getNome());
//
//        return retornarDTO(pessoaRepository.save(pessoaEntityRecuperada));
//    }

    public Pet getPetbyId(Integer idPet) throws EntidadeNaoEncontradaException {
        return petRepository.findById(idPet)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

//    public void delete(Integer idPet) throws Exception{
//        Pet pet = getPetbyId(idPet);
//
//        Pessoa pessoa = pessoaService.returnPersonById(pet.getPessoa().getIdPessoa());
//        pet.setPessoa(null);
//        pessoa.setPets(null);
//
//        petRepository.delete(pet);
//        pessoaService.update(pessoa);
//
//    }

    public Pet converterDTO(PetCreateDTO dto) {
        return objectMapper.convertValue(dto, Pet.class);
    }
    public PetDTO retornarDTO(Pet entity) {
        return objectMapper.convertValue(entity, PetDTO.class);
    }
}



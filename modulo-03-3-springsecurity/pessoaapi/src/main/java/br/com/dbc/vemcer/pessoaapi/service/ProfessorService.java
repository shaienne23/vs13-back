package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.dto.ProfessorDTO;
import br.com.dbc.vemcer.pessoaapi.entity.Professor;
import br.com.dbc.vemcer.pessoaapi.repository.ProfessorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {
  private final ProfessorRepository professorRepository;
  public final ObjectMapper objectMapper;

  public List<ProfessorDTO> list() {
    return professorRepository.findAll().stream()
        .map(this::retornarDTO).collect(Collectors.toList());
  }

  public ProfessorDTO create(ProfessorDTO professorDTO) {
    Professor entity = professorRepository.save(converterDTO(professorDTO));
    return retornarDTO(entity);
  }

  public ProfessorDTO retornarDTO(Professor entity) {
    return objectMapper.convertValue(entity, ProfessorDTO.class);
  }

  public Professor converterDTO(ProfessorDTO dto) {
    return objectMapper.convertValue(dto, Professor.class);
  }

}

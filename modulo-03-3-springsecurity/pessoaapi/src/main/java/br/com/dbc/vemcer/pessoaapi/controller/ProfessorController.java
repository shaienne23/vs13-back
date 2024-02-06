package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.dto.ProfessorDTO;
import br.com.dbc.vemcer.pessoaapi.repository.ProfessorRepository;
import br.com.dbc.vemcer.pessoaapi.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService service;
    private final ProfessorRepository repository;

    @PostMapping
    public ProfessorDTO create(@RequestBody @Valid ProfessorDTO professorDTO) throws Exception {
        return service.create(professorDTO);
    }

    @GetMapping
    public List<ProfessorDTO> list() {
        return service.list();
    }

}



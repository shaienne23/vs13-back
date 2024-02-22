package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.PetDTO;
import br.com.dbc.vemcer.pessoaapi.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pet")
@Validated
@Slf4j
@Component
public class PetControler {
private final PetService petService;


    @GetMapping
    public ResponseEntity<List<PetDTO>>list(){
        log.info("Listando Pets!");
        List<PetDTO> pets = petService.list();
        log.info("Pets Listados.");

        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PetDTO> create(@Valid @RequestBody PetCreateDTO pet) throws Exception{
        log.info("Criando Pet.");
        PetDTO petCriado = petService.create(pet);
        log.info("Pets Criados");
        return new ResponseEntity<>(petCriado, HttpStatus.OK);
    }

//    @PutMapping("/{idPet}")
//    public ResponseEntity<PetDTO>update(@PathVariable("idPet") Integer id,
//                        @Valid @RequestBody PetCreateDTO petUpdate) throws Exception{
//        log.info("Atualizando Pet!");
//        return new ResponseEntity<>(petService.update(id, petUpdate), HttpStatus.OK);
//    }

//    @DeleteMapping("/{idPet")
//    public ResponseEntity<Void> delete(@PathVariable("idPet") Integer id) throws Exception{
//        log.info("Deletando Pet!");
//        petService.delete(id);
//        log.info("Pet Deletado.");
//        return ResponseEntity.ok().build();
//    }

}

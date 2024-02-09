package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.entity.Endereco;
import br.com.dbc.vemcer.pessoaapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/endereco")
public class EnderecoControler {
    private final EnderecoService enderecoService;

    public EnderecoControler(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> listAll() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> listByIdEndereco(@PathVariable("idEndereco") Integer id){
        return enderecoService.listByIdEndereco(id);
    }
    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa){
        return enderecoService.listByIdPessoa(idPessoa);

    }
    @GetMapping ("/byname")
    public List<Endereco> listByName(@RequestParam("estado") String estado){
        return enderecoService.listByName(estado);
    }

    @PostMapping ("/{idPessoa}")
    public ResponseEntity<Endereco> create( @PathVariable("idPessoa") Integer idPessoa,
                            @Valid @RequestBody Endereco endereco)throws Exception{
        return new ResponseEntity<>(enderecoService.create(idPessoa, endereco), HttpStatus.OK);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update( @PathVariable("idEndereco") Integer id,
                          @Valid @RequestBody Endereco enderecoAtualizar) throws Exception{
        return new ResponseEntity<>(enderecoService.update(id, enderecoAtualizar), HttpStatus.OK);
    }
    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete (@PathVariable("idEndereco") Integer id) throws Exception{
        enderecoService.delete(id);
        return ResponseEntity.ok().build();
    }
}

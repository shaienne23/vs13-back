package br.com.dbc.vemcer.pessoaapi.controller;

import br.com.dbc.vemcer.pessoaapi.entity.Endereco;
import br.com.dbc.vemcer.pessoaapi.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Endereco create( @PathVariable("idPessoa") Integer idPessoa,
                            @RequestBody Endereco endereco)throws Exception{
        return enderecoService.create(idPessoa, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco update( @PathVariable("idEndereco") Integer id,
                          @RequestBody Endereco enderecoAtualizar) throws Exception{
        return enderecoService.update(id, enderecoAtualizar);
    }
    @DeleteMapping("/{idEndereco}")
    public void delete (@PathVariable("idEndereco") Integer id) throws Exception{
        enderecoService.delete(id);
    }
}

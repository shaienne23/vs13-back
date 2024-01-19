package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.entity.Endereco;
import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemcer.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemcer.pessoaapi.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaRepository pessoaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaRepository = pessoaRepository;
    }

public Endereco create(Integer idPessoa, Endereco endereco)throws Exception{
    Pessoa pessoa = getPessoa(idPessoa);
    endereco.setIdPessoa(idPessoa);
    return  EnderecoRepository.create(endereco);
}

public List<Endereco> list() {
    return enderecoRepository.list();
    }

    public Endereco update(Integer idPessoa, Endereco enderecoAtualizar) throws Exception {
        Pessoa pessoa = getPessoa(idPessoa);
        Endereco enderecoRecuperado = getEndereco(idPessoa);
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        return enderecoRecuperado;
    }

public void delete(Integer id) throws Exception{
    Endereco enderecoRecuperado = getEndereco(id);
    enderecoRepository.delete(enderecoRecuperado);
}
    public List<Endereco> listByIdEndereco(Integer id) {
    return enderecoRepository.listByIdEndereco(id);
    }
    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }
    public List<Endereco> listByName(String estado){
    return enderecoRepository.listByName(estado);
}

    private Endereco getEndereco(Integer id) throws Exception {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() ->  new RegraDeNegocioException("Endereço não encontrado!"));
    }
    private Pessoa getPessoa(Integer id) throws Exception{
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
    }

}

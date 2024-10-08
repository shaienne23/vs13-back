package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.entity.Endereco;
import br.com.dbc.vemcer.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

private final EnderecoRepository enderecoRepository;

public EnderecoService(EnderecoRepository enderecoRepository) {
    this.enderecoRepository = enderecoRepository;
}

public Endereco create(Integer idPessoa, Endereco endereco){
    endereco.setIdPessoa(idPessoa);
    return  EnderecoRepository.create(endereco);
}

public List<Endereco> list() {
    return enderecoRepository.list();
    }

    public Endereco update(Integer idPessoa, Endereco enderecoAtualizar) throws Exception {
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
                .orElseThrow(() -> new Exception("Endereço não encontrado!"));
    }


}

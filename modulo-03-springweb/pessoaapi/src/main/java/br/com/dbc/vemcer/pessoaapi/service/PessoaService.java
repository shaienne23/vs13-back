package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemcer.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class PessoaService {
private final PessoaRepository pessoaRepository;

    public Pessoa create(Pessoa pessoa)throws Exception{
    return  pessoaRepository.create(pessoa);
}

public List<Pessoa> list() {
        return pessoaRepository.list();
    }
public Pessoa update ( Integer id, Pessoa pessoaAtualizar) throws Exception{
    Pessoa pessoaRecuperada = getPessoa(id);
    pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
    pessoaRecuperada.setNome(pessoaAtualizar.getNome());
    pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

    return pessoaRecuperada;
}
public void delete(Integer id) throws Exception{
    Pessoa pessoaRecuperada = getPessoa(id);
    pessoaRepository.delete(pessoaRecuperada);
}

public List<Pessoa> listByName(String nome){
    return pessoaRepository.listByName(nome);
}

public Pessoa findById(Integer id) throws Exception{
    return getPessoa(id);
}
private Pessoa getPessoa(Integer id) throws Exception{
    Pessoa pessoaRecuperada = pessoaRepository.list().stream()
            .filter(pessoa -> pessoa.getIdPessoa().equals(id))
            .findFirst()
            .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
    return pessoaRecuperada;
}
}

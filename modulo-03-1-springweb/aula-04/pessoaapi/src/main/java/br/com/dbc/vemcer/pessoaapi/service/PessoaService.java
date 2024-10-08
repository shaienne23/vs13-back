package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemcer.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.util.List;


@Service
public class PessoaService {
private final PessoaRepository pessoaRepository;

public PessoaService(PessoaRepository pessoaRepository) {
            this.pessoaRepository =  pessoaRepository;
    }

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

private Pessoa getPessoa(Integer id) throws Exception{
    Pessoa pessoaRecuperada = pessoaRepository.list().stream()
            .filter(pessoa -> pessoa.getIdPessoa().equals(id))
            .findFirst()
            .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
    return pessoaRecuperada;
}
}

package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import br.com.dbc.vemcer.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemcer.pessoaapi.repository.PessoaRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

@Service
public class PessoaService {
private final PessoaRepository pessoaRepository;

public PessoaService(PessoaRepository pessoaRepository) {
            this.pessoaRepository =  pessoaRepository;
    }

public Pessoa create(Pessoa pessoa)throws Exception{
    if (pessoa != null && StringUtils.isBlank(pessoa.getNome())) {
        throw new Exception("Erro ao inserir,campo Nome vazio!");
    } else if (pessoa != null && ObjectUtils.isEmpty(pessoa.getDataNascimento())) {
               throw new Exception("Erro ao inserir,campo data de nascimento vazio!");
    } else if (pessoa != null && StringUtils.isBlank(pessoa.getCpf())) {
        throw new Exception("Erro ao inserir, campo CPF vazio!");
    }else{
        String cpf = pessoa.getCpf().replaceAll("[^0-9]", "");
        if(cpf.length()!= 11){
            throw new Exception("Erro ao inserir, o CPF deve ter 11 digitos!");
        }
    }return  pessoaRepository.create(pessoa);
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
            .orElseThrow(() -> new Exception("Pessoa não encontrada!"));
    return pessoaRecuperada;
}
}

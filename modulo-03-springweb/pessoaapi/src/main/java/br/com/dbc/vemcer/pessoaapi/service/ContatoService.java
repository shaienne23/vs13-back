package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.entity.Contato;
import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemcer.pessoaapi.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ContatoService {
private final ContatoRepository contatoRepository;

public Contato create(Contato contato){
    return  contatoRepository.create(contato);
}

public List<Contato> list() {

    return contatoRepository.list();
    }

public Contato update ( Integer id, Contato contatoAtualizar) throws Exception{
    Contato contatoRecuperado = getContato(id);
    contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
    contatoRecuperado.setNumero(contatoAtualizar.getNumero());
    contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());

    return contatoRecuperado;
}
public void delete(Integer id) throws Exception{
    Contato contatoRecuperado = getContato(id);
    contatoRepository.delete(contatoRecuperado);
}

public List<Contato> listByName(String descricao){

    return contatoRepository.listByName(descricao);
}

private Contato getContato(Integer id) throws Exception{
    Contato contatoRecuperado = contatoRepository.list().stream()
            .filter(pessoa -> pessoa.getIdContato().equals(id))
            .findFirst()
            .orElseThrow(() ->  new RegraDeNegocioException("Contato não encontrado!"));
    return contatoRecuperado;
}
}

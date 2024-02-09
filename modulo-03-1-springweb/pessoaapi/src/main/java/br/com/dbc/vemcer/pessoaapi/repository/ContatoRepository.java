package br.com.dbc.vemcer.pessoaapi.repository;

import br.com.dbc.vemcer.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemcer.pessoaapi.entity.Contato;
import br.com.dbc.vemcer.pessoaapi.entity.TipoContato;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
@Repository
public class ContatoRepository {
    private static List<Contato> listaContatos;
    private AtomicInteger COUNTER = new AtomicInteger();
    private final PessoaRepository pessoaRepository;
    public ContatoRepository(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
        this.listaContatos = new ArrayList<>();
        initializeContatos();
    }
    private void initializeContatos() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, pessoaRepository.list().get(0).getIdPessoa(),
                TipoContato.RESIDENCIAL, "27997279376", "Contato Shay."));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, pessoaRepository.list().get(1).getIdPessoa(),
                TipoContato.COMERCIAL, "27999220989", "Contato Gustavo."));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, pessoaRepository.list().get(2).getIdPessoa(),
                TipoContato.RESIDENCIAL, "27934567891", "Contato Daniel."));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, pessoaRepository.list().get(3).getIdPessoa(),
                TipoContato.COMERCIAL, "27984567891", "Contato Ted."));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*5*/, pessoaRepository.list().get(4).getIdPessoa(),
                TipoContato.RESIDENCIAL, "27945678917", "Contato Jake."));
    }
    public Contato create (Contato contato){
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }
    public List<Contato> list(){
        return listaContatos;
    }
    public List<Contato> listByName(String descricao) {
        return listaContatos.stream()
                .filter(contato -> contato.getDescricao().toUpperCase().contains(descricao.toUpperCase()))
                .collect(Collectors.toList());
    }
    public ContatoCreateDTO update(Integer id,
                                   ContatoCreateDTO contatoAtualizar) {
        contatoAtualizar.setTipoContato(contatoAtualizar.getTipoContato());
        contatoAtualizar.setNumero(contatoAtualizar.getNumero());
        contatoAtualizar.setDescricao(contatoAtualizar.getDescricao());
        return contatoAtualizar;
    }
    public void delete(Contato contato) {
        listaContatos.remove(contato);
    }
}


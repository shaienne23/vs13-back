package br.com.dbc.vemcer.pessoaapi.repository;


import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
@Repository
public class PessoaRepository {
    private static List<Pessoa> listaPessoas; // cria a arraylist para as informaçoes simuladas do banco de dados.
    private AtomicInteger COUNTER = new AtomicInteger(); // cria um contador e gerador de ID automatico.
    public PessoaRepository() {
        this.listaPessoas = new ArrayList<>();
        initializePessoas();
    }
    private void initializePessoas(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // formato data
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*1*/, "Shaienne Oliveira", LocalDate.parse("28/05/1991", formatter), "12345678910"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*2*/, "Gustavo Oliveira", LocalDate.parse("07/12/2012", formatter), "12345678911"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*3*/, "Daniel de Oliveira", LocalDate.parse("12/06/1995", formatter), "12345678912"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*4*/, "Ted da Silva", LocalDate.parse("13/02/2021", formatter), "12345678916"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*5*/, "Jake de Oliveira", LocalDate.parse("01/07/2020", formatter), "12345678917"));
    }
    //CRIAR
    public Pessoa create (Pessoa pessoa){
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoas.add(pessoa);
        return pessoa;
    }
    // retorna a lista completa de pessoas
    public List<Pessoa> list(){
        return listaPessoas;
    }
    //retorna uma nova lista com apenas as pessoas que o nome contém a string fornecida como parâmetro.
    public List<Pessoa> listByName(String nome) {
        return listaPessoas.stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }
// atualiza pessoas
    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) {
        pessoaAtualizar.setCpf(pessoaAtualizar.getCpf());
        pessoaAtualizar.setNome(pessoaAtualizar.getNome());
        pessoaAtualizar.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaAtualizar;
    }
    // deleta as pessoas
    public void delete(Pessoa pessoa) {
        listaPessoas.remove(pessoa);
    }

}

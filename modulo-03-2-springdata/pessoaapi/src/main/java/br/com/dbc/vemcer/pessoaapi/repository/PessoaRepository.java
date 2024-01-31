package br.com.dbc.vemcer.pessoaapi.repository;

import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    List<Pessoa> findByNomeContainingIgnoreCase(String nome);

    List<Pessoa> findByCpf(String cpf);

    List<Pessoa> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);
    }

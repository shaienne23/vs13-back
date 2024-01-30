package br.com.dbc.vemcer.pessoaapi.repository;

import br.com.dbc.vemcer.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    public List<PessoaEntity> findAllByNomeContains(String nome);
    }


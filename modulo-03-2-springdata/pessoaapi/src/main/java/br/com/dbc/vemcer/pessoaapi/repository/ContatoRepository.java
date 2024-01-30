package br.com.dbc.vemcer.pessoaapi.repository;

import br.com.dbc.vemcer.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemcer.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {
    public List<ContatoEntity> findAllByDescricaoContains(String descricao);
}


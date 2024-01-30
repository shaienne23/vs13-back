package br.com.dbc.vemcer.pessoaapi.repository;

import br.com.dbc.vemcer.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemcer.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    public List<EnderecoEntity> findAllByEstadoContains(String estado);


    public List<EnderecoEntity> findAllByIdEnderecoContains(Integer id);
}

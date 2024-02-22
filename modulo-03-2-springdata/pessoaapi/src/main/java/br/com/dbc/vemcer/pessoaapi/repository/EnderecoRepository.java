package br.com.dbc.vemcer.pessoaapi.repository;

import br.com.dbc.vemcer.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemcer.pessoaapi.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    public List<Endereco> findAllByEstadoContains(String estado);
    public List<Endereco> listByIdPessoa(Integer idPessoa);

    public List<Endereco> findAllByIdEnderecoContains(Integer id);
}

package br.com.dbc.vemcer.pessoaapi.repository;

import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    List<Pessoa> findByNomeContainingIgnoreCase(String nome);
    List<Pessoa> findByCpf(String cpf);
    List<Pessoa> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

    //query busca por cpf
    @Query("select p from PESSOA p where p.cpf = :cpf")
    Pessoa procurarPorCpf(@Param("cpf") String cpf);

//exercicio01
    //endereços por país;
//endereços por id da pessoa;

// contatos por tipo de contato;

// pessoas por data de nascimento entre duas datas;

// pessoas que possuem endereço;

//exercicio2
//endereços por cidade ou país;

// endereços sem complemento;

// contatos por idPessoa;

// pessoas que não possuem endereço;

//task
//Trazer a pessoa com todos os dados (endereços, contatos e pets).

// ● Disponibilizar um endpoint no PessoaController “/pessoa-completo” que deve
// receber o id da pessoa por request param como opcional, se não for informado listar todos,
// se for informado, listar somente a pessoa pelo id;

//task
@Query(nativeQuery = true, value =
        "SELECT " +
                "    p.ID_PESSOA, " +
                "    p.NOME AS PESSOA_NOME, " +
                "    p.DATA_NASCIMENTO, " +
                "    p.CPF, " +
                "    p.EMAIL, " +
                "    c.ID_CONTATO, " +
                "    c.ID_PESSOA AS CONTATO_ID_PESSOA, " +
                "    c.TIPO_CONTATO, " +
                "    c.NUMERO AS CONTATO_NUMERO, " +
                "    c.DESCRICAO AS CONTATO_DESCRICAO, " +
                "    ep.ID_ENDERECO, " +
                "    ep.ID_PESSOA AS ENDERECO_ID_PESSOA, " +
                "    ep.TIPO_ENDERECO, " +
                "    ep.LOGRADOURO AS ENDERECO_LOGRADOURO, " +
                "    ep.NUMERO AS ENDERECO_NUMERO, " +
                "    ep.COMPLEMENTO AS ENDERECO_COMPLEMENTO, " +
                "    ep.CEP AS ENDERECO_CEP, " +
                "    ep.CIDADE AS ENDERECO_CIDADE, " +
                "    ep.ESTADO AS ENDERECO_ESTADO, " +
                "    ep.PAIS AS ENDERECO_PAIS, " +
                "    pet.NOME AS PET_NOME " +
                "FROM " +
                "    VEM_SER.PESSOA p " +
                "LEFT JOIN " +
                "    VEM_SER.CONTATO c ON p.ID_PESSOA = c.ID_PESSOA " +
                "LEFT JOIN " +
                "    VEM_SER.ENDERECO_PESSOA ep ON p.ID_PESSOA = ep.ID_PESSOA " +
                "LEFT JOIN " +
                "    VEM_SER.PET pet ON p.ID_PESSOA = pet.ID_PESSOA " +
                "WHERE " +
                "    p.ID_PESSOA = :idPessoa")
    List<Pessoa> findPessoaCompleta(@Param("idPessoa") Integer idPessoa);
}



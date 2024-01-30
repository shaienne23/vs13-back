package br.com.dbc.vemcer.pessoaapi.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_endereco_contato", allocationSize = 1)

    @Column(name = "id_endereco")
    private Integer idEndereco;

    private Integer idPessoa;

    @Column(name = "tipo")
    private TipoEndereco tipo;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero" )
    private Integer numero;

    @Column(name = "complemento" )
    private String complemento;

    @Column(name = "cep")
    private String cep;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "pais")
    private String pais;
}

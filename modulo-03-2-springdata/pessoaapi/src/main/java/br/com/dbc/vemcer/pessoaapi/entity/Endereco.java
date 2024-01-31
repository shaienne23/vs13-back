package br.com.dbc.vemcer.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "ENDERECO_PESSOA")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco", allocationSize = 1)
//    @Column(name = "id_endereco")
    private Integer idEndereco;
    private Integer idPessoa;

    @NotNull(message = "O Tipo de endereço não pode ser Nulo!")
    @Column(name = "tipo")
    @Convert(converter = TipoEnderecoConverter.class)
    private TipoEndereco tipo;

    @Size(max = 250, message = "O Logradouro deve ter no máximo 250 caracteres")
    @NotEmpty(message = "Logradouro não pode estar vazio ou nulo!")
    @Column(name = "logradouro")
    private String logradouro;

    @NotNull(message = "O número não pode ser Nulo!")
    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    @NotEmpty(message = "Campo CEP não pode ser vazio ou nulo")
    @Size(max = 8, message = "O CEP deve conter no máximo 8 caracteres")
    @Column(name = "cep")
    private String cep;

    @Size(max = 250, message = "A cidade deve ter no máximo 250 caracteres")
    @NotEmpty(message = "Cidade não pode ser vazio ou nulo!")
    @Column(name = "cidade")
    private String cidade;

    @NotNull(message = "Estado não pode ser Nulo!")
    @Column(name = "estado")
    private String estado;

    @NotNull(message = "País não pode ser Nulo!")
    @Column(name = "pais")
    private String pais;
}

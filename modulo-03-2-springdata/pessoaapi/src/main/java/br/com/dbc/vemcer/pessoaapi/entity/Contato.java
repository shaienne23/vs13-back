package br.com.dbc.vemcer.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "CONTATO")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;

    private Integer idPessoa;

    @NotNull(message = "Tipo de Contato não pode ser nulo")
    @Column(name = "tipo")
    @Convert(converter = TipoContatoConverter.class)
    private TipoContato tipoContato;

    @Size(max = 13, message = "O numero deve ter no máximo 13 caracteres")
    @NotBlank(message = "Campo numero não pode ser nulo")
    @Column(name = "numero")
    private String numero;

    @NotEmpty(message = "Descrição não pode estar vazia ou nula!")
    @Column(name = "descricao")
    private String descricao;
}

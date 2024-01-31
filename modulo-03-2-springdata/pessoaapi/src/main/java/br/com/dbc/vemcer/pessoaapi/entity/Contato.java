package br.com.dbc.vemcer.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "CONTATO")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private Pessoa pessoaEntity;

    @NotNull(message = "Tipo de Contato não pode ser nulo")
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo")
    private TipoContato tipoContato;

    @Size(max = 13, message = "O numero deve ter no máximo 13 caracteres")
    @NotBlank(message = "Campo numero não pode ser nulo")
    @Column(name = "numero")
    private String numero;

    @NotEmpty(message = "Descrição não pode estar vazia ou nula!")
    @Column(name = "descricao")
    private String descricao;
}

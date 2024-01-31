package br.com.dbc.vemcer.pessoaapi.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "PESSOA")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "A data de nascimento não pode ser nula")
    @Past(message = "A data de Nascimento deve ser no passado!")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @CPF(message = "CPF Inválido!")
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 caracteres")
    @Column(name = "cpf")
    private String cpf;
}

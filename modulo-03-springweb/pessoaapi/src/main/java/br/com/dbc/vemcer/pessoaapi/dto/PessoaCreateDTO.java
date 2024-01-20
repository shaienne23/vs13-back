package br.com.dbc.vemcer.pessoaapi.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

        private Integer idPessoa;

        @NotBlank(message = "O nome não pode estar em branco")
        @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
        private String nome;

        @NotNull(message = "A data de nascimento não pode ser nula")
        @Past(message = "A data de Nascimento deve ser no passado!")
        private LocalDate dataNascimento;

        @CPF(message = "CPF Invalido!")
        @Size(min = 11, max = 11, message = "O CPF deve conter 11 caracteres")
        private String cpf;}


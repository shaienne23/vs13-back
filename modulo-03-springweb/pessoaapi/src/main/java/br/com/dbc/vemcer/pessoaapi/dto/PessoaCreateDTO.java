package br.com.dbc.vemcer.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
        @Schema(description = "Nome da Pessoa", required = true, example = "Shaienne")
        private String nome;

        @NotNull(message = "A data de nascimento não pode ser nula")
        @Past(message = "A data de Nascimento deve ser no passado!")
        @Schema(description = "Data de Nascimento", required = true, example = "28/05/1991")
        private LocalDate dataNascimento;

        @CPF(message = "CPF Invalido!")
        @Size(min = 11, max = 11, message = "O CPF deve conter 11 caracteres")
        @Schema(description = "Cpf Pessoa", required = true, example = "12387645603")
        private String cpf;

}


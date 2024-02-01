package br.com.dbc.vemcer.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class PessoaCreateDTO {

        private Integer idPessoa;

        @NotBlank(message = "O nome não pode estar em branco")
        @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
        @Schema(description = "Nome da Pessoa", required = true, example = "Shaienne")
        private String nome;

        @NotNull(message = "A data de nascimento não pode ser nula")
        @Past(message = "A data de Nascimento deve ser no passado!")
        @Schema(description = "Data de Nascimento", required = true, example = "1991-05-28")
        private LocalDate dataNascimento;

        @CPF(message = "CPF Invalido!")
        @Size(min = 11, max = 11, message = "O CPF deve conter 11 caracteres")
        @Schema(description = "Cpf Pessoa", required = true, example = "12387645603")

        private String cpf;
        @Schema(description = "Email Pessoa", required = true, example = "fulano@mail.com")
        @Email
        private String email;

}


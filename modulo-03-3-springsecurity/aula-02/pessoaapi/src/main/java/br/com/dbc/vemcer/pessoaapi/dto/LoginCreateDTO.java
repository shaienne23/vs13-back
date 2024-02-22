package br.com.dbc.vemcer.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class LoginCreateDTO {

    @NotNull
    private String login;
    @NotNull
    @Size(max = 11)
    private String senha;


}

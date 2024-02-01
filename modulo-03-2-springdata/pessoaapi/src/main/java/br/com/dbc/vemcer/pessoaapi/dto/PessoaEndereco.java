package br.com.dbc.vemcer.pessoaapi.dto;

import br.com.dbc.vemcer.pessoaapi.entity.Endereco;

import java.util.Set;

public class PessoaEndereco extends PessoaDTO{
    private Set<Endereco> enderecos;
}

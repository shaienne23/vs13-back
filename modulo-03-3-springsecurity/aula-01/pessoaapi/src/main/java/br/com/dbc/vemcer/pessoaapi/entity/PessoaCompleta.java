package br.com.dbc.vemcer.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
//@Entity
public class PessoaCompleta {
        //@Id
        private Integer idPessoa;
        private String nome;
        private LocalDate dataNascimento;
        private String cpf;
        private Set<Pet> pets;
        private Set<Contato> contatos;
        private Set<Endereco> enderecos;
    }


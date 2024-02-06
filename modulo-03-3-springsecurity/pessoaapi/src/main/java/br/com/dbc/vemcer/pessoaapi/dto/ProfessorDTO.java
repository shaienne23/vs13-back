package br.com.dbc.vemcer.pessoaapi.dto;

import br.com.dbc.vemcer.pessoaapi.entity.pk.ProfessorPK;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProfessorDTO {
  @NotNull
  private ProfessorPK professorPK;

  @NotNull
  private String nome;

  @NotNull
  private Double salario;
}

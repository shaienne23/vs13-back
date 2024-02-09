package br.com.dbc.vemcer.pessoaapi.entity;

import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;

import java.util.Arrays;

public enum TipoContato {

    RESIDENCIAL(1),
    COMERCIAL(2);

    private Integer tipo;

    TipoContato(Integer tipo){
        this.tipo = tipo;
    }

    public Integer getTipo(){
        return tipo;
    }

    public static TipoContato ofTipo(Integer tipo) throws RegraDeNegocioException {
        return Arrays.stream(TipoContato.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Tipo de Contato inválido! "));
    }

}
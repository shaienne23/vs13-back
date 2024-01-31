package br.com.dbc.vemcer.pessoaapi.entity;

public enum TipoContato {
    RESIDENCIAL(1),
    COMERCIAL(2);

    private Integer tipo;

    TipoContato(Integer tipo){
        this.tipo = tipo;
    }
}

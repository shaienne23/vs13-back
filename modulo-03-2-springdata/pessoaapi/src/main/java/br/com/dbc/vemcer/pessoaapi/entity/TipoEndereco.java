package br.com.dbc.vemcer.pessoaapi.entity;

import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;
import java.util.Arrays;

public enum TipoEndereco {
    RESIDENCIAL(1),
    COMERCIAL(2);
    private Integer tipo;
    TipoEndereco(Integer tipo) {
        this.tipo = tipo;
    }
    public Integer getTipo() {
        return tipo;
    }
    public static TipoEndereco ofTipo(Integer tipo) throws RegraDeNegocioException {
        return Arrays.stream(TipoEndereco.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Tipo de Endereço inválido! "));
    }
}

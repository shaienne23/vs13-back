package br.com.dbc.vemcer.pessoaapi.entity;

import javax.persistence.AttributeConverter;

import static br.com.dbc.vemcer.pessoaapi.entity.TipoEndereco.COMERCIAL;
import static br.com.dbc.vemcer.pessoaapi.entity.TipoEndereco.RESIDENCIAL;

public class TipoEnderecoConverter implements AttributeConverter<TipoEndereco, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TipoEndereco tipoEndereco) {
        if (tipoEndereco == null) {
            return null;
        }

        switch (tipoEndereco) {
            case RESIDENCIAL:
                return 1;
            case COMERCIAL:
                return 2;
            default:
                throw new IllegalArgumentException("The " + tipoEndereco + " not supported.");
        }
    }

    @Override
    public TipoEndereco convertToEntityAttribute(Integer dbData) {

        if (dbData == null){
            return null;
        }

        switch (dbData){
            case 1:
                return RESIDENCIAL;
            case 2:
                return COMERCIAL;
            default:
                throw new IllegalArgumentException("The " + dbData + " not supported.");
        }
    }
}

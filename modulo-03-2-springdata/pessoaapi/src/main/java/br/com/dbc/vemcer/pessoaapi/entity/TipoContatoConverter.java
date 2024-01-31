package br.com.dbc.vemcer.pessoaapi.entity;
import static br.com.dbc.vemcer.pessoaapi.entity.TipoContato.COMERCIAL;
import static br.com.dbc.vemcer.pessoaapi.entity.TipoContato.RESIDENCIAL;
import javax.persistence.AttributeConverter;

public class TipoContatoConverter implements AttributeConverter<TipoContato, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TipoContato tipoContato) {
        if (tipoContato == null) {
            return null;
        }

        switch (tipoContato) {
            case RESIDENCIAL:
                return 1;
            case COMERCIAL:
                return 2;
            default:
                throw new IllegalArgumentException("The " + tipoContato + " not supported.");
        }
    }

    @Override
    public TipoContato convertToEntityAttribute(Integer dbData) {

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

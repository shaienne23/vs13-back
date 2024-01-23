package br.com.dbc.vemcer.pessoaapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesReader {
    @Value("${ambiente}")
    private String ambiente;

    @Value("${usuario}")
    private String usuario;

    public String getAmbiente() {
        return ambiente;
    }

    public String getUsuario() {
        return usuario;
    }
}

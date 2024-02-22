package br.com.dbc.vemcer.pessoaapi.security;

import br.com.dbc.vemcer.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemcer.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    static final String HEADER_STRING = "Authorization";
    private final UsuarioService usuarioService;

    public String getToken(UsuarioEntity usuarioEntity) {
        String tokenTexto = usuarioEntity.getLogin() + ";" + usuarioEntity.getSenha();
        String token = Base64.getEncoder().encodeToString(tokenTexto.getBytes());
        return token;
    }
    // token = yeAGieha9eH(E8 = rafa;123
    public Optional<UsuarioEntity> isValid(String token) {
        if(token == null){
            return Optional.empty();
        }
        byte[] decodedBytes = Base64.getUrlDecoder().decode(token);
        String decoded = new String(decodedBytes);
        String[] split = decoded.split(";");
        return usuarioService.findByLoginAndSenha(split[0], split[1]);
    }
}

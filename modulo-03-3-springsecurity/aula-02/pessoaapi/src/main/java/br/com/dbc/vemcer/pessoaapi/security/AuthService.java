package br.com.dbc.vemcer.pessoaapi.security;

import br.com.dbc.vemcer.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemcer.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
        private final UsuarioService usuarioService;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<UsuarioEntity> usuarioOptional = usuarioService.findByLogin(username);
            return usuarioOptional
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario inválido"));
        }
    }



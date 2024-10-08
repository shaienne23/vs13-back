package br.com.dbc.vemcer.pessoaapi.controller;


import br.com.dbc.vemcer.pessoaapi.dto.LoginCreateDTO;
import br.com.dbc.vemcer.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemcer.pessoaapi.entity.Cargo;
import br.com.dbc.vemcer.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemcer.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemcer.pessoaapi.security.TokenService;
import br.com.dbc.vemcer.pessoaapi.service.CargoService;
import br.com.dbc.vemcer.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioService usuarioService;
    private final CargoService cargoService;

    private final TokenService tokenService;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {
        Optional<UsuarioEntity> byLoginAndSenha = usuarioService.findByLoginAndSenha(loginDTO.getLogin(), loginDTO.getSenha());
        if (byLoginAndSenha.isPresent()) {
            return tokenService.generateToken(byLoginAndSenha.get());
        } else {
            throw new RegraDeNegocioException("Usuário ou senha inválidos");
        }
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioEntity> cadastrar(@Valid @RequestBody LoginCreateDTO loginCreateDTO) throws Exception {
        UsuarioEntity novoUsuario = new UsuarioEntity();
        novoUsuario.setLogin(loginCreateDTO.getLogin());
        novoUsuario.setSenha(loginCreateDTO.getSenha());

        Set<Cargo> cargos = new HashSet<>();
        for (String cargoNome : loginCreateDTO.getRoles()) {
            Cargo cargo = cargoService.findByNome(cargoNome)
                    .orElseThrow(() -> new RuntimeException("Cargo não encontrado: " + cargoNome));
            cargos.add(cargo);
        }
        novoUsuario.setCargos(cargos);

        UsuarioEntity usuarioCadastrado = usuarioService.save(novoUsuario);

        return ResponseEntity.ok(usuarioCadastrado);
    }
    @GetMapping("/usuario-logado")
    public ResponseEntity<Optional<UsuarioEntity>>usuarioLogado()throws RegraDeNegocioException{
        return new ResponseEntity<>(usuarioService.getLoggedUser(), HttpStatus.OK);
    }

}

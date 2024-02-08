package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.entity.Cargo;
import br.com.dbc.vemcer.pessoaapi.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CargoService {
    private final CargoRepository cargoRepository;

    public Optional<Cargo> findById(Integer id) {
        return cargoRepository.findById(id);
    }

    public Optional<Cargo> findByNome(String nome) {
        return cargoRepository.findByNome(nome);
    }

    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

}

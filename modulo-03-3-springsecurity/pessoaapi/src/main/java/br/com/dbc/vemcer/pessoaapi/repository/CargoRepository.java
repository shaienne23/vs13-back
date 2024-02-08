package br.com.dbc.vemcer.pessoaapi.repository;

import br.com.dbc.vemcer.pessoaapi.entity.Cargo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
     Optional<Cargo> findById(Integer id);
    Optional<Cargo> findByNome(String nome);
    Cargo save(Cargo cargo);
}

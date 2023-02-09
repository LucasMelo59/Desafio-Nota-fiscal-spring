package br.demo.notafiscal.model.repositories;

import br.demo.notafiscal.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByName(String razaoSocial);
    Cliente findByTipo(String tipo);
}

package br.demo.notafiscal.model.repositories;

import br.demo.notafiscal.dto.ClienteDto;
import br.demo.notafiscal.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


    @Query(value = "Select * from cliente t where ( :razao_social is null or lower(t.razao_social) like lower(concat('%', :razao_social, '%')))", nativeQuery = true)
    List<Cliente> findByRazaoSocial(@Param("razao_social") String razao_social);
//
    @Query(value = "SELECT COUNT(u) FROM cliente u WHERE tipo_regime_tributario = :tipoRegimeTributario", nativeQuery = true)
    long countForTipoRegimeTributario(@Param("tipoRegimeTributario") String tipoRegimeTributario);

    @Query("SELECT COUNT(u) FROM cliente u")
    long countClientes();
}

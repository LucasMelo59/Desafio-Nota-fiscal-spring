package br.demo.notafiscal.model.repositories;

import br.demo.notafiscal.model.entities.NotasFiscais;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotasFiscaisRepository extends JpaRepository<NotasFiscais, Integer> {

    @Query(value = "select * from notas_fiscais nf where cliente_id = :idCliente", nativeQuery = true)
    public List<NotasFiscais> buscarporCliente(@Param("idCliente") int idCliente);

    @Query(value= "select count(nf) from notas_fiscais nf", nativeQuery = true)
    public Long countNotasFiscais();

//    select c.razao_social, sum(nf.valor) from notas_fiscais nf inner join cliente c on c.id = nf.cliente_id where c.id = 1 group by c.razao_social

}

package br.demo.notafiscal.service;

import br.demo.notafiscal.model.entities.NotasFiscais;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotasFiscaisService {
    public List<NotasFiscais> buscarPorCliente(int idCliente);

    public NotasFiscais cadastrarNotas(NotasFiscais notasFiscais);
    public List<NotasFiscais> findAllNotas();
    public Long countNotasFiscais();
    public void delete(int id) throws Exception;
}

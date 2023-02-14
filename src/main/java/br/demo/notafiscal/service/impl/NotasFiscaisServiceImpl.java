package br.demo.notafiscal.service.impl;

import br.demo.notafiscal.model.entities.Cliente;
import br.demo.notafiscal.model.entities.NotasFiscais;
import br.demo.notafiscal.model.repositories.NotasFiscaisRepository;
import br.demo.notafiscal.service.NotasFiscaisService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotasFiscaisServiceImpl implements NotasFiscaisService {

    @Autowired
    NotasFiscaisRepository notasFiscaisRepository;

    @Override
    public List<NotasFiscais> buscarPorCliente(int idCliente) {
        return notasFiscaisRepository.buscarporCliente(idCliente);
    }

    @Override
    public NotasFiscais cadastrarNotas(NotasFiscais notasFiscais) {
        return notasFiscaisRepository.save(notasFiscais);
    }

    @Override
    public List<NotasFiscais> findAllNotas() {
        return notasFiscaisRepository.findAll();
    }

    @Override
    public Long countNotasFiscais(){
        return notasFiscaisRepository.countNotasFiscais();
    }

    @Override
    public void delete(int id)  {
        Optional<NotasFiscais> remover = notasFiscaisRepository.findById(id);
        notasFiscaisRepository.deleteById(id);
    }

}

package br.demo.notafiscal.service.impl;

import br.demo.notafiscal.dto.ClienteDto;
import br.demo.notafiscal.model.entities.Cliente;
import br.demo.notafiscal.model.repositories.ClienteRepository;
import br.demo.notafiscal.service.ClienteService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired

    @Override
    public Cliente cadastrar(ClienteDto clienteDto) {
        return clienteRepository.save(clienteDto);
    }

    @Override
    public List<Cliente> listaDeClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente detalhar(String razaoSocial) {
//        Optional<Cliente> obj = clienteRepository.findById(razaoSocial);
        return null;
    }

    @Override
    public void remover(int id) {
    Optional<Cliente> remover = clienteRepository.findById(id);
    if(remover.isPresent()){
        clienteRepository.deleteById(id);
    }else {
        throw new ObjectNotFoundException("Objeto não encontrado");
    }
    }
}

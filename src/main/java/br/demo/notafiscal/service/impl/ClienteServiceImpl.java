package br.demo.notafiscal.service.impl;

import br.demo.notafiscal.dto.ClienteDto;
import br.demo.notafiscal.exceptions.ObjectNotFoundException;
import br.demo.notafiscal.model.entities.Cliente;
import br.demo.notafiscal.model.repositories.ClienteRepository;
import br.demo.notafiscal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired

    @Override
    public Cliente cadastrar(ClienteDto clienteDto) {
        S save = clienteRepository.save(clienteDto);
        return save;
    }

    @Override
    public List<Cliente> listaDeClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente detalhar(@RequestParam String razaoSocial) {
        Optional<Cliente> obj = clienteRepository.findByName(razaoSocial);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
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

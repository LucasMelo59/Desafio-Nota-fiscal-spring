package br.demo.notafiscal.service.impl;

import br.demo.notafiscal.dto.ClienteDto;
import br.demo.notafiscal.exceptions.ObjectNotFoundException;
import br.demo.notafiscal.model.entities.Cliente;
import br.demo.notafiscal.model.repositories.ClienteRepository;
import br.demo.notafiscal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listaDeClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Object> findByRazaoSocial (String razaoSocial) {
        return clienteRepository.findByRazaoSocial(razaoSocial);
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

    @Override
    public Long countCLientes() {
        return clienteRepository.countClientes();
    }

    @Override
    public Long countForTipoRegimeTributario(String tipoRegimeTributario) {
        return clienteRepository.countForTipoRegimeTributario(tipoRegimeTributario);
    }
}

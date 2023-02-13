package br.demo.notafiscal.service.impl;

import br.demo.notafiscal.dto.ClienteDto;
import br.demo.notafiscal.model.entities.Cliente;
import br.demo.notafiscal.model.repositories.ClienteRepository;
import br.demo.notafiscal.service.ClienteService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Cliente> findByRazaoSocial (String razao_social) {
        return clienteRepository.findByRazaoSocial(razao_social);
    }
    @Override
    public Cliente findById (int id){
        return clienteRepository.findById(id).get();
    }

    @Override
    public void remover(int id) {
    Optional<Cliente> remover = clienteRepository.findById(id);
    if(remover.isPresent()){
        clienteRepository.deleteById(id);
    }
    remover.ifPresentOrElse(x -> {
        clienteRepository.deleteById(id);
    }, () -> {
         new Exception("objeto não encontrado");
        });
    }

    @Override
    public Long countCLientes() {
        return clienteRepository.countClientes();
    }

    @Override
    public Long countForTipoRegimeTributario(String tipoRegimeTributario) {
        return clienteRepository.countForTipoRegimeTributario(tipoRegimeTributario);
    }

    @Override
    public List<ClienteDto> findAllDto() {
        return clienteRepository.findAll().stream().map(ClienteDto::new).collect(Collectors.toList());
    }
}

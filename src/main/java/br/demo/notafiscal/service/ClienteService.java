package br.demo.notafiscal.service;

import br.demo.notafiscal.dto.ClienteDto;
import br.demo.notafiscal.model.entities.Cliente;

import java.util.List;

public interface ClienteService {

    public Cliente cadastrar(Cliente cliente);
    public List<Cliente> listaDeClientes();
    public List<Object> findByRazaoSocial (String razaoSocial);
    public void remover(int id);
    public Long countCLientes();
    public Long countForTipoRegimeTributario(String tipoRegimeTributario);


}

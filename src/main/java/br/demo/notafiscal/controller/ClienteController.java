package br.demo.notafiscal.controller;

import br.demo.notafiscal.dto.ClienteDto;
import br.demo.notafiscal.model.entities.Cliente;
import br.demo.notafiscal.service.ClienteService;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar(){
        return clienteService.listaDeClientes();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){
        return ResponseEntity.ok().body(clienteService.cadastrar(cliente));
    }
    @RequestMapping("/find")
    @GetMapping
    public ResponseEntity<List<Cliente>> findByRazaoSocial (@RequestHeader(required = false) String razao_social){
        return ResponseEntity.ok().body(clienteService.findByRazaoSocial(razao_social));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") int id){
        clienteService.remover(id);
    }
    @GetMapping
    @RequestMapping("/countCLientes")
    public Long countCLientes(){
        return clienteService.countCLientes();
    }
    @PostMapping
    @RequestMapping("/countPorTipo")
    public Long countCLienteForType(@RequestBody String tipo){
        return clienteService.countForTipoRegimeTributario(tipo);
    }

    @GetMapping("/teste/{id}")
    public Cliente findById(@PathVariable("id") int id){
    return clienteService.findById(id);
    }

    @GetMapping("/dto")
    public List<ClienteDto> listAllDto(){
        return clienteService.findAllDto();
    }
}

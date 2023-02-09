package br.demo.notafiscal.controller;

import br.demo.notafiscal.dto.ClienteDto;
import br.demo.notafiscal.model.entities.Cliente;
import br.demo.notafiscal.service.ClienteService;
import jakarta.transaction.Transactional;
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
    public ResponseEntity<Cliente> cadastrar(@RequestBody ClienteDto clienteDto){
        return ResponseEntity.ok().body(clienteService.cadastrar(clienteDto));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ClienteDto> detalhar(@PathVariable(value = "id") int id){
//        return ResponseEntity.ok().body(clienteService.detalhar(id));
//    }

    @DeleteMapping("/{id")
    public void deletar(@PathVariable("id") int id){
        clienteService.remover(id);
    }
}

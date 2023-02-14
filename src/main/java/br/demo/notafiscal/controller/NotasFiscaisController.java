package br.demo.notafiscal.controller;

import br.demo.notafiscal.model.entities.NotasFiscais;
import br.demo.notafiscal.service.NotasFiscaisService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obterNotasFiscais")
public class NotasFiscaisController {

    @Autowired
    NotasFiscaisService notasFiscaisService;

    @GetMapping
    @RequestMapping("/{idCliente}")
    public List<NotasFiscais> buscarNotasPorCliente(@PathVariable("idCliente") int idCliente){
        return notasFiscaisService.buscarPorCliente(idCliente);
    }

    @GetMapping
    @RequestMapping("/countNotasFiscais")
    public Long countNotasFiscais(){
        return notasFiscaisService.countNotasFiscais();
    }

    @GetMapping
    @RequestMapping("/notas")
    public List<NotasFiscais> findAllNotas(){
        return notasFiscaisService.findAllNotas();
    }

    @PostMapping
    @Transactional
    @RequestMapping("/cadastrar")
    public  ResponseEntity<NotasFiscais>  cadastrar(@RequestBody NotasFiscais notasFiscais) {
        return ResponseEntity.ok().body(notasFiscaisService.cadastrarNotas(notasFiscais));
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) throws Exception {
            notasFiscaisService.delete(id);
    }
}

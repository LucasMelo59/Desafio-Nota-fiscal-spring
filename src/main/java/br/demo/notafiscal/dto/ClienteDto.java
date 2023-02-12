package br.demo.notafiscal.dto;

import br.demo.notafiscal.model.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    private int id;
    private String razaoSocial;

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.razaoSocial = cliente.getRazao_social();
    }


}

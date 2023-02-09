package br.demo.notafiscal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private String razaoSocial;
    private String cnjpj;
    private String tipoRegimeTributario;
    private String email;
}

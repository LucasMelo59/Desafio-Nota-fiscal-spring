package br.demo.notafiscal.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String razaoSocial;
    private String cnjpj;
    private String tipoRegimeTributario;
    private String email;

    public Cliente(String razaoSocial, String cnjpj, String tipoRegimeTributario, String email) {
        this.razaoSocial = razaoSocial;
        this.cnjpj = cnjpj;
        this.tipoRegimeTributario = tipoRegimeTributario;
        this.email = email;
    }
}

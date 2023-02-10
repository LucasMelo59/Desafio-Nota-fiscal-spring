package br.demo.notafiscal.model.entities;

import br.demo.notafiscal.model.enuns.TipoRegimeTributario;
import jakarta.persistence.*;
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
    @Column(name = "razao_social")
    private String razaoSocial;
    private String cnpj;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_regime_tributario")
    private TipoRegimeTributario tipoRegimeTributario;
    private String email;

    public Cliente(String razaoSocial, String cnpj, String email) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;   
        this.email = email;
    }
}

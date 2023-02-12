package br.demo.notafiscal.model.entities;

import br.demo.notafiscal.model.enuns.TipoRegimeTributario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "notasFiscais")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotasFiscais {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "cliente_id")
    private int cliente;
    private double valor;
    @Column(name = "data_emissao")
    private Date data_emissao;
}

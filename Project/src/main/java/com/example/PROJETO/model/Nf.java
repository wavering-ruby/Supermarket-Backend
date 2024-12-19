package com.example.PROJETO.model;
import java.time.LocalDate;
//import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
//import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Nf")
@Table(name = "Nf")

public class Nf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nf_codigo", nullable = false)
    private Integer nf_codigo;

    @Column(name = "nf_data_emissao", nullable = false)
    private LocalDate nf_data_emissao;

    @Column(name = "nf_total", nullable = false)
    private Double nf_total;

    @ManyToOne
    @JoinColumn(name = "cli_codigo", referencedColumnName = "cli_codigo")
    @JsonBackReference // Evita o loop infinito de serialização
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fun_codigo", referencedColumnName = "fun_codigo")
    @JsonBackReference // Evita o loop infinito de serialização
    private Funcionario funcionario;

    public Nf(){}

    public Nf(LocalDate nf_data_emissao, Double nf_total) {
        this.nf_data_emissao = nf_data_emissao;
        this.nf_total = nf_total;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getNf_data_emissao() {
        return nf_data_emissao;
    }

    public void setNf_data_emissao(LocalDate nf_data_emissao) {
        this.nf_data_emissao = nf_data_emissao;
    }

    public Double getNf_total() {
        return nf_total;
    }

    public void setNf_total(Double nf_total){
        this.nf_total = nf_total;
    }
}
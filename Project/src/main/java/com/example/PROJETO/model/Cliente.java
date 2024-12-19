package com.example.PROJETO.model;

import java.util.Set;

import jakarta.persistence.*;
//import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity(name = "Cliente")
@Table(name = "Cliente")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_codigo", nullable = false)
    private Integer cliCodigo;

    @Column(name = "cli_nome", nullable = false)
    private String cli_nome;

    @Column(name = "cli_telefone", nullable = false)
    private String cli_telefone;

    @Column(name = "cli_email", nullable = false)
    private String cli_email;

    @Column(name = "cli_endereco", nullable = false)
    private String cli_endereco;

    @OneToMany(mappedBy = "cliente")
    private Set<Nf> Nf;

    public Cliente(){
    }

    public Cliente(RequestCliente RequestCliente){
        this.cliCodigo = RequestCliente.cliCodigo();
        this.cli_nome = RequestCliente.cli_nome();
        this.cli_telefone = RequestCliente.cli_telefone();
        this.cli_email = RequestCliente.cli_email();
        this.cli_endereco = RequestCliente.cli_endereco();
    }

    public Integer getCliCodigo(){
        return cliCodigo;
    }

    public String getCli_nome(){
        return cli_nome;
    }

    public void setCli_nome(String cli_nome){
        this.cli_nome = cli_nome;
    }

    public String getCli_telefone(){
        return cli_telefone;
    }

    public void setCli_telefone(String cli_telefone){
        this.cli_telefone = cli_telefone;
    }

    public String getCli_email(){
        return cli_email;
    }

    public void setCli_email(String cli_email){
        this.cli_email = cli_email;
    }

    public String getCli_endereco(){
        return cli_endereco;
    }

    public void setCli_endereco(String cli_endereco){
        this.cli_endereco = cli_endereco;
    }
}

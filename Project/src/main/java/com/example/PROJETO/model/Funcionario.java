package com.example.PROJETO.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@Entity
@Table(name = "Funcionario")

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fun_codigo", nullable = false)
    private Integer funCodigo;

    @Column(name = "fun_nome", nullable = false)
    private String fun_nome;


    @Column(name = "fun_email", nullable = false)
    private String fun_email;


    @Column(name = "fun_cargo", nullable = false)
    private String fun_cargo;

    @OneToMany(mappedBy = "funcionario")
    @JsonIgnore
    private Set<Nf> Nf;

    public Funcionario(){
    }

    public Funcionario(RequestFuncionario RequestFuncionario){
        this.funCodigo = RequestFuncionario.funCodigo();
        this.fun_nome = RequestFuncionario.fun_nome();
        this.fun_email = RequestFuncionario.fun_email();
        this.fun_cargo = RequestFuncionario.fun_cargo();
    }

    public Integer getFunCodigo(){
        return funCodigo;
    }

    public String getFun_nome(){
        return fun_nome;
    }

    public void setFun_nome(String fun_nome){
        this.fun_nome = fun_nome;
    }

    public String getFun_email(){
        return fun_email;
    }

    public void setFun_email(String fun_email){
        this.fun_email = fun_email;
    }
    public String getFun_cargo(String fun_cargo) {
    	return fun_cargo;
    }
    public void setFun_cargo(String fun_cargo) {
    	this.fun_cargo= fun_cargo;
    }
}

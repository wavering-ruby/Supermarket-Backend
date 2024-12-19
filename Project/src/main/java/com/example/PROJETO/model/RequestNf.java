package com.example.PROJETO.model;
import java.time.LocalDate;

public class RequestNf {
    private LocalDate nf_data_emissao;
    private Double nf_total;
    private Integer fun_codigo;  // Código do Funcionário
    private Integer cli_codigo;  // Código do Cliente

    // Getters e Setters
    public LocalDate getNf_data_emissao() {
        return nf_data_emissao;
    }

    public void setNf_data_emissao(LocalDate nf_data_emissao) {
        this.nf_data_emissao = nf_data_emissao;
    }

    public Double getNf_total() {
        return nf_total;
    }

    public void setNf_total(Double nf_total) {
        this.nf_total = nf_total;
    }

    public Integer getFun_codigo() {
        return fun_codigo;
    }

    public void setFun_codigo(Integer fun_codigo) {
        this.fun_codigo = fun_codigo;
    }

    public Integer getCli_codigo() {
        return cli_codigo;
    }

    public void setCli_codigo(Integer cli_codigo) {
        this.cli_codigo = cli_codigo;
    }
}
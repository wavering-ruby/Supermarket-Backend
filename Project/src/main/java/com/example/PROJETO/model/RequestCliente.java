package com.example.PROJETO.model;

public record RequestCliente(
    Integer cliCodigo, 
    String cli_nome, 
    String cli_telefone, 
    String cli_email, 
    String cli_endereco
){}
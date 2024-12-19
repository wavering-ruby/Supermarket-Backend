-- Active: 1731289063453@@127.0.0.1@5432@postgres@public
/* 
    Observações, rodar essa porra de forma individual, 
    dar um CTRL + A e rodar pode não funcionar.
*/

CREATE TABLE produto ( /* Tabela de Produtos */
  prd_codigo SERIAL PRIMARY KEY,
  prd_nome VARCHAR(255) NOT NULL,
  prd_tipo VARCHAR(255) NOT NULL,
  prd_preco DECIMAL(10, 2) NOT NULL,
  prd_quantidade INT NOT NULL
);

CREATE TABLE cliente (
  cli_codigo SERIAL PRIMARY KEY,
  cli_nome VARCHAR(255) NOT NULL,
  cli_telefone VARCHAR(255) NOT NULL,
  cli_email VARCHAR(255) NOT NULL,
  cli_endereco VARCHAR(255) NOT NULL
);

CREATE TABLE funcionario (
    fun_codigo SERIAL PRIMARY KEY,
    fun_nome VARCHAR(255) NOT NULL,
    fun_telefone VARCHAR(255) NOT NULL,
    fun_email VARCHAR(255) NOT NULL,
    fun_endereco VARCHAR(255) NOT NULL
);

CREATE TABLE nf (
    nf_codigo SERIAL PRIMARY KEY,
    nf_data_emissao DATE NOT NULL,
    fun_codigo INT NOT NULL,
    nf_total DECIMAL(10, 2) NOT NULL,
    cli_codigo INT NOT NULL,
    FOREIGN KEY(cli_codigo) REFERENCES cliente(cli_codigo),
    FOREIGN KEY(fun_codigo) REFERENCES funcionario(fun_codigo)
);

CREATE TABLE itens_venda (
    itv_codigo SERIAL PRIMARY KEY,
    itv_qtd_prod INT NOT NULL,
    nf_codigo INT NOT NULL,
    prd_codigo INT NOT NULL,
    FOREIGN KEY(nf_codigo) REFERENCES nf(nf_codigo),
    FOREIGN KEY(prd_codigo) REFERENCES produto(prd_codigo)
);
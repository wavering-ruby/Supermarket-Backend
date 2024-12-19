-- Active: 1732283987742@@127.0.0.1@5432@postgres
INSERT INTO produto (prd_nome, prd_tipo, prd_preco, prd_quantidade) VALUES
('Produto A', 'Alimentício', 15.99, 100),
('Produto B', 'Bebida', 5.49, 200),
('Produto C', 'Higiene', 9.99, 50),
('Produto D', 'Alimentício', 12.75, 75),
('Produto E', 'Eletrônico', 299.99, 10),
('Produto F', 'Vestuário', 45.00, 150),
('Produto G', 'Alimentício', 7.89, 90),
('Produto H', 'Ferramenta', 125.00, 30),
('Produto I', 'Cosmético',22.50, 120),
('Produto J', 'Bebida', 3.25, 300);

INSERT INTO funcionario (fun_nome, fun_telefone, fun_email, fun_cargo, fun_endereco) VALUES
('Mateus G Mendes de Paula', '(12) 99191-9191', 'mateus.paula@gmail.com',' Gerente', 'Rua Teodoro Rico'),
('Paula Mendes', '(12) 99191-9191', 'mateus.arbad@gmail.com','Caixa', 'Rua Teodoro Pobre'),
('Mendes de Paula', '(12) 99191-9191', 'mateus.dadasd@gmail.com','estoquista','Rua Teodoro Medio');

INSERT INTO cliente(cli_nome, cli_telefone, cli_email, cli_endereco ) VALUES
('Angelo salvatii', '(11) 55669-8769', 'salvatti.Brawl@gmail.com', 'Rua Brawl Stars'),
('Enade Pegadinhas', '(12) 44869-4523', 'PegadinhadoMalandro@gmail.com', 'Rua pegadinha'),
('José Filipe STARS da Silva', '(12) 56789-4123', 'Stars@gmail.com', 'Rua das Estrelas')

INSERT INTO nf (nf_data_emissao, fun_codigo, nf_total, cli_codigo) VALUES
('2024-11-10', 1, 150.75, 1),
('2024-11-11', 2, 320.50, 2),
('2024-11-12', 3, 200.00, 3),
('2024-11-13', 1, 450.25, 3),
('2024-11-14', 2, 375.00, 3);

-- Active: 1731289063453@@127.0.0.1@5432@postgres
INSERT INTO produto (prd_nome, prd_tipo, prd_data_validade, prd_preco, prd_quantidade) VALUES
('Produto A', 'Alimentício', '2025-01-15', 15.99, 100),
('Produto B', 'Bebida', '2024-12-01', 5.49, 200),
('Produto C', 'Higiene', '2024-11-20', 9.99, 50),
('Produto D', 'Alimentício', '2025-02-28', 12.75, 75),
('Produto E', 'Eletrônico', '2026-07-15', 299.99, 10),
('Produto F', 'Vestuário', '2025-03-10', 45.00, 150),
('Produto G', 'Alimentício', '2025-06-01', 7.89, 90),
('Produto H', 'Ferramenta', '2026-01-25', 125.00, 30),
('Produto I', 'Cosmético', '2024-12-31', 22.50, 120),
('Produto J', 'Bebida', '2025-08-15', 3.25, 300);

INSERT INTO funcionario (fun_nome, fun_telefone, fun_email, fun_endereco) VALUES
('Mateus G Mendes de Paula', '(12) 99191-9191', 'mateus.paula@gmail.com', 'Rua Teodoro Rico'),
('Paula Mendes', '(12) 99191-9191', 'mateus.arbad@gmail.com', 'Rua Teodoro Pobre'),
('Mendes de Paula', '(12) 99191-9191', 'mateus.dadasd@gmail.com', 'Rua Teodoro Medio');

INSERT INTO nf (nf_data_emissao, fun_codigo, nf_total, cli_codigo) VALUES
('2024-11-10', 1, 150.75, 1),
('2024-11-11', 2, 320.50, 2),
('2024-11-12', 3, 200.00, 3),
('2024-11-13', 1, 450.25, 4),
('2024-11-14', 2, 375.00, 5);

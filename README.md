# Supermarket - Backend

## About
This repository contains a back-end of a simple supermarket, showing the relationships between invoices (NF), products and customers.

## What is needed
• To run this project, you need to configure Postman to use port specified in the configuration. If you want to see the documetation click this link: https://www.postman.com/waveringruby/my-workspace/collection/ccie99a/supermarket?action=share&creator=39610508.

• The database server used is PostgreSQL, so, you need PgAdmin to view the tables. In the DDL folder, you will find some SQL functions to creat and drop the tables needed to run this project.

• Remember to install Spring Boot and the technologies mentioned in the "Usage Technology" section.

## Usage Technology
![Springboot](https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white&labelColor=6DB33F)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgreSQL&logoColor=white&labelColor=4169E1)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white&labelColor=FF6C37)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black&labelColor=F7DF1E)

## Team
| **Name**| **LinkedIn** |
|:----------------------:|:----------------------------------------------------------:|
| Angelo Salvatti | [![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?style=flat-square&logo=linkedin&labelColor=blue)](https://www.linkedin.com/in/angelo-salvatti-2a991023a/) |
| Mateus Gabriel Mendes de Paula | [![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?style=flat-square&logo=linkedin&labelColor=blue)](https://www.linkedin.com/in/mateus-gabriel-mendes-de-paula-9589891b2/)|
| Pedro Alves de Moraes Medeiros | [![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?style=flat-square&logo=linkedin&labelColor=blue)](https://www.linkedin.com/in/pedro-alves-de-moraes-medeiros-775a9a268/) |

<h4>
If you have any questions, I can help you. Just send me a message through the LinkedIn link (I'm Mateus Gabriel Mendes de Paula). I'll be happy to solve you with any issues. :)
</h4>

## Details of Code

### Cliente (Client)

#### Controller

Basically, for each table in DER relatioship, one controller is created to do the CRUD commands, like Put, Post, Delete or Get

For exemple, the table Cliente have to Get's.

```JAVASCRIPT
@GetMapping
public ResponseEntity getAllClientes(){
    var AllClientes = clienteRepository.findAll();
    return ResponseEntity.ok(AllClientes);
}
```

This Get mapping is resposible to show all registers on the Cliente table. 

```JAVASCRIPT
@GetMapping("/compra-cli")
public List<QuantidadeTotalCompra> QuantidadeTotalCompra(){
    List<QuantidadeTotalCompra> valor_compra_cliente = clienteRepository.QuantidadeTotalCompra();
    return valor_compra_cliente;
}
```

This Get is responsible to show the user a relatory of quantity of itens bought by a client. Like the example below:

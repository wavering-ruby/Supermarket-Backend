# Supermarket - Backend

## About
This repository contains a back-end of a simple supermarket, showing the relationships between invoices (NF), products and customers.

---

## What is needed
• To run this project, you need to configure Postman to use port specified in the configuration. If you want to see the documetation click this link: https://www.postman.com/waveringruby/my-workspace/collection/ccie99a/supermarket?action=share&creator=39610508.

• The database server used is PostgreSQL, so, you need PgAdmin to view the tables. In the DDL folder, you will find some SQL functions to creat and drop the tables needed to run this project.

• Remember to install Spring Boot and the technologies mentioned in the "Usage Technology" section.

---

## Usage Technology
<div align="center">
    
![Springboot](https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white&labelColor=6DB33F)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgreSQL&logoColor=white&labelColor=4169E1)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white&labelColor=FF6C37)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black&labelColor=F7DF1E)

</div>

---

## Team
<div align="center">

| **Name**| **LinkedIn** |
|:----------------------:|:----------------------------------------------------------:|
| Angelo Salvatti | [![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?style=flat-square&logo=linkedin&labelColor=blue)](https://www.linkedin.com/in/angelo-salvatti-2a991023a/) |
| Mateus Gabriel Mendes de Paula | [![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?style=flat-square&logo=linkedin&labelColor=blue)](https://www.linkedin.com/in/mateus-gabriel-mendes-de-paula-9589891b2/)|
| Pedro Alves de Moraes Medeiros | [![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?style=flat-square&logo=linkedin&labelColor=blue)](https://www.linkedin.com/in/pedro-alves-de-moraes-medeiros-775a9a268/) |

</div>

<h4>
If you have any questions, I can help you. Just send me a message through the LinkedIn link (I'm Mateus Gabriel Mendes de Paula). I'll be happy to solve you with any issues. :)
</h4>

---

## Details of Code

### Cliente (Client)

#### Controller

Basically, for each table in DER relatioship, one controller is created to do the CRUD commands, like Put, Post, Delete or Get.

---

##### Get
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

---

##### Post

Responsible for add a new register to the data base table. If the request body it's ok, basically just add a new register, if didn't, just return a default "Error" message to the user.

```JAVASCRIPT
@PostMapping("/novo-cliente")
public ResponseEntity<Cliente> RegistrarProduto(@RequestBody @Valid RequestCliente data){
    Cliente newCliente = new Cliente(data);

    clienteRepository.save(newCliente);

    // Apenas retornando uma mensagem para o postman inserir um novo produto
    return ResponseEntity.ok(newCliente);
}
```

---

##### Put

Responsible for updating a table record, based on a number sent by the front-end. The number is for the primary-key *codigo* (can named *id* to). First of all she search in the column (primary-key) for the number, if didn't find anything, the code will return a default "Not Found" menssage. If is true, then the register is updated and saved in the data base.

```JAVASCRIPT
@PutMapping("/atualizar/{codigo}")
public ResponseEntity<?> AtualizarCliente(@PathVariable Integer codigo, @RequestBody @Valid RequestCliente data){
    Optional<Cliente> clienteAtualizar = clienteRepository.findById(codigo);

    if(clienteAtualizar.isEmpty()){
        return ResponseEntity.notFound().build();            
    } else {
        Cliente clienteAtualizado = clienteAtualizar.get();

        // Após verificar se o valor pesquisado não está vazio, ele vai pegar o produto que ele quer atualizar (pesquisado anteriormente pelo o id)
        // e vai substituir os valores, retornando o "produtoAtualizado"
        clienteAtualizado.setCli_nome(data.cli_nome());
        clienteAtualizado.setCli_telefone(data.cli_telefone());
        clienteAtualizado.setCli_email(data.cli_email());
        clienteAtualizado.setCli_endereco(data.cli_endereco());
        
        // Aqui ele está salvando as alterações que foram feitas pelo o postman
        clienteRepository.save(clienteAtualizado);

        return ResponseEntity.ok(clienteAtualizado);
    }
}
```

---

### Funcionario (Employee)

#### Controller

For each table in the DER relationship, a controller is created to execute CRUD commands such as Put, Post, Delete, and Get.

---

##### Get

The example below returns all records from the table `Funcionario`.

```java
@GetMapping
public ResponseEntity getAllFuncionarios(){
    var AllFuncionarios = funcionarioRepository.findAll();
    return ResponseEntity.ok(AllFuncionarios);
}
```

This Get mapping is responsible for displaying all records in the table `Funcionario`.

```java
@GetMapping("/totalporcargo")
public List<FuncionarioporCargoDTO> FuncionarioporCargoDTO() {
    List<FuncionarioporCargoDTO> TotalFuncionarios = funcionarioRepository.FuncionarioporCargo();
    return TotalFuncionarios;
}
```

---

##### Post

Responsible for adding a new record to the database table. If the request body is correct, the record will be inserted. Otherwise, a standard error message will be returned to the user.

```java
@PostMapping("/novo-funcionario")
public ResponseEntity<Funcionario> RequestFuncionario(@RequestBody @Valid RequestFuncionario data){
    Funcionario newFuncionario = new Funcionario(data);

    funcionarioRepository.save(newFuncionario);

    // Apenas retornando uma mensagem para o Postman inserir um novo funcionário
    return ResponseEntity.ok(newFuncionario);
}
```

---

##### Put

Responsible for updating a record in the table based on a number sent by the front-end. This number corresponds to the primary key *code* (which can also be called *id*). First, the column (primary key) is searched for the number entered. If not found, returns a standard "Not Found" message. Otherwise, the record is updated and saved in the database.

```java
@PutMapping("/atualizar/{codigo}")
public ResponseEntity<?> AtualizarFuncionario(@PathVariable Integer codigo, @RequestBody @Valid RequestFuncionario data){
    Optional<Funcionario> funcionarioAtualizar = funcionarioRepository.findById(codigo);

    if(funcionarioAtualizar.isEmpty()){
        return ResponseEntity.notFound().build();            
    } else {
        Funcionario funcionarioAtualizado = funcionarioAtualizar.get();

        // Após verificar que o valor pesquisado não está vazio, os valores do funcionário são atualizados
        funcionarioAtualizado.setFun_email(data.fun_email());
        funcionarioAtualizado.setFun_nome(data.fun_nome());
        funcionarioAtualizado.setFun_cargo(data.fun_cargo());
        
        // Salva as alterações feitas pelo Postman
        funcionarioRepository.save(funcionarioAtualizado);

        return ResponseEntity.ok(funcionarioAtualizado);
    }
}
```

---

##### Delete

Responsible for removing an employee from the database, as long as he does not have an associated Invoice (NF). If there is an associated NF, it returns an error message stating that the employee cannot be removed until the NF is deleted.

```java
@DeleteMapping("/remover/{codigo}")
public ResponseEntity RemoverCliente(@PathVariable Integer codigo){
    boolean existeNF = nfRepository.existsByFuncionario_funCodigo(codigo);
    if(existeNF){
        return ResponseEntity.badRequest().body("Funcionario não pode ser removido enquanto houver NF em seu nome.");
    }

    Optional<Funcionario> funcionario = funcionarioRepository.findById(codigo);
    if(funcionario.isEmpty()){
        return ResponseEntity.notFound().build();
    }

    funcionarioRepository.deleteById(codigo);
    return ResponseEntity.noContent().build();
}
```


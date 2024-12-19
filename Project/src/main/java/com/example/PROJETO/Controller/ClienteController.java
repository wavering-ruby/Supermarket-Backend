package com.example.PROJETO.Controller;

import com.example.PROJETO.DTO.QuantidadeTotalCompra;
import com.example.PROJETO.Repository.ClienteRepository;
import com.example.PROJETO.Repository.NfRepository;
import com.example.PROJETO.model.Cliente;
import com.example.PROJETO.model.RequestCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @SuppressWarnings("rawtypes") // Apenas para tirar o aviso que estava no ResponseEntity
    @GetMapping
    public ResponseEntity getAllClientes(){
        var AllClientes = clienteRepository.findAll();
        return ResponseEntity.ok(AllClientes);
    }

    @GetMapping("/compra-cli")
    public List<QuantidadeTotalCompra> QuantidadeTotalCompra(){
        List<QuantidadeTotalCompra> valor_compra_cliente = clienteRepository.QuantidadeTotalCompra();
        return valor_compra_cliente;
    }

    @PostMapping("/novo-cliente")
    public ResponseEntity<Cliente> RegistrarProduto(@RequestBody @Valid RequestCliente data){
        Cliente newCliente = new Cliente(data);

        clienteRepository.save(newCliente);

        // Apenas retornando uma mensagem para o postman inserir um novo produto
        return ResponseEntity.ok(newCliente);
    }

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

    @Autowired
    private NfRepository nfRepository;

    @DeleteMapping("/remover/{codigo}")
    @SuppressWarnings("rawtypes") // Apenas para tirar o aviso que estava no ResponseEntity
    public ResponseEntity RemoverCliente(@PathVariable Integer codigo){
        boolean existeNF = nfRepository.existsByCliente_cliCodigo(codigo);
        if(existeNF){
            return ResponseEntity.badRequest().body("Cliente não pode ser removivo enquanto houver NF em seu nome.");
        }

        Optional<Cliente> cliente = clienteRepository.findById(codigo);
        if(cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        clienteRepository.deleteById(codigo);
        return ResponseEntity.noContent().build();
    }
}

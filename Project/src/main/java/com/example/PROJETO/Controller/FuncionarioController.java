package com.example.PROJETO.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PROJETO.DTO.FuncionarioporCargoDTO;
import com.example.PROJETO.Repository.FuncionarioRepository;
import com.example.PROJETO.Repository.NfRepository;
import com.example.PROJETO.model.Funcionario;
import com.example.PROJETO.model.RequestFuncionario;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @SuppressWarnings("rawtypes") // Apenas para tirar o aviso que estava no ResponseEntity
    @GetMapping
    public ResponseEntity getAllFuncionarios(){
        var AllFuncionarios = funcionarioRepository.findAll();
        return ResponseEntity.ok(AllFuncionarios);
    }

    @GetMapping("/totalporcargo")
    public List<FuncionarioporCargoDTO> FuncionarioporCargoDTO() {
        List<FuncionarioporCargoDTO> TotalFuncionarios = funcionarioRepository.FuncionarioporCargo();
        return TotalFuncionarios;
    }

    @PostMapping("/novo-funcionario")
    public ResponseEntity<Funcionario> RequestFuncionario(@RequestBody @Valid RequestFuncionario data){
        Funcionario newFuncionario = new Funcionario(data);

        funcionarioRepository.save(newFuncionario);

        // Apenas retornando uma mensagem para o postman inserir um novo produto
        return ResponseEntity.ok(newFuncionario);
    }

    @PutMapping("/atualizar/{codigo}")
    public ResponseEntity<?> AtualizarFuncionario(@PathVariable Integer codigo, @RequestBody @Valid RequestFuncionario data){
        Optional<Funcionario> funcionarioAtualizar = funcionarioRepository.findById(codigo);

        if(funcionarioAtualizar.isEmpty()){
            return ResponseEntity.notFound().build();            
        } else {
            Funcionario funcionarioAtualizado = funcionarioAtualizar.get();

            // Após verificar se o valor pesquisado não está vazio, ele vai pegar o produto que ele quer atualizar (pesquisado anteriormente pelo o id)
            // e vai substituir os valores, retornando o "produtoAtualizado"
            funcionarioAtualizado.setFun_email(data.fun_email());
            funcionarioAtualizado.setFun_nome(data.fun_nome());
            funcionarioAtualizado.setFun_cargo(data.fun_cargo());
            
            // Aqui ele está salvando as alterações que foram feitas pelo o postman
            funcionarioRepository.save(funcionarioAtualizado);

            return ResponseEntity.ok(funcionarioAtualizado);
        }
    }

    @Autowired
    private NfRepository nfRepository;

    @DeleteMapping("/remover/{codigo}")
    @SuppressWarnings("rawtypes") // Apenas para tirar o aviso que estava no ResponseEntity
    public ResponseEntity RemoverCliente(@PathVariable Integer codigo){
        boolean existeNF = nfRepository.existsByFuncionario_funCodigo(codigo);
        if(existeNF){
            return ResponseEntity.badRequest().body("Funcionario não pode ser removivo enquanto houver NF em seu nome.");
        }

        Optional<Funcionario> funcionario = funcionarioRepository.findById(codigo);
        if(funcionario.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        funcionarioRepository.deleteById(codigo);
        return ResponseEntity.noContent().build();
    }
}
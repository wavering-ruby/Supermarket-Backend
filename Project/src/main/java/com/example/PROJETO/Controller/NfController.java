package com.example.PROJETO.Controller;

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

import com.example.PROJETO.Repository.ClienteRepository;
import com.example.PROJETO.Repository.FuncionarioRepository;
import com.example.PROJETO.Repository.NfRepository;
import com.example.PROJETO.model.Cliente;
import com.example.PROJETO.model.Funcionario;
import com.example.PROJETO.model.Nf;
import com.example.PROJETO.model.RequestNf;

@RestController
@RequestMapping("/nfs")
public class NfController {
    private final NfRepository nfRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public NfController(NfRepository nfRepository, ClienteRepository clienteRepository, FuncionarioRepository funcionarioRepository) {
        this.nfRepository = nfRepository;
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @SuppressWarnings("rawtypes") // Apenas para tirar o aviso que estava no ResponseEntity
    @GetMapping
    public ResponseEntity getAllNf(){
        var AllNf = nfRepository.findAll();
        return ResponseEntity.ok(AllNf);
    }

    @PostMapping("nova-nf")
    public ResponseEntity<Nf> criarNotaFiscal(@RequestBody RequestNf data) {
        // Busca o cliente pelo ID
        Cliente cliente = clienteRepository.findById(data.getCli_codigo())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + data.getCli_codigo()));

        // Busca o funcionário pelo ID
        Funcionario funcionario = funcionarioRepository.findById(data.getFun_codigo())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + data.getFun_codigo()));

        // Cria a nova NotaFiscal a partir de RequestNf
        Nf newNf = new Nf(data.getNf_data_emissao(), data.getNf_total());

        // Associa a nota fiscal ao cliente e ao funcionário
        newNf.setCliente(cliente);
        newNf.setFuncionario(funcionario);

        // Salva a nota fiscal
        Nf notaFiscalCriada = nfRepository.save(newNf);
        // Retorna a resposta
        return ResponseEntity.ok(notaFiscalCriada);
    }

    // Método PUT para atualizar a Nota Fiscal
    @PutMapping("atualizar/{id}")
    public ResponseEntity<Nf> atualizarNotaFiscal(@PathVariable Integer id, @RequestBody RequestNf data) {
        // Busca a nota fiscal pelo ID
        Nf notaFiscalExistente = nfRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota Fiscal não encontrada com o ID: " + id));

        // Atualiza os dados da nota fiscal
        if (data.getCli_codigo() != null) {
            Cliente cliente = clienteRepository.findById(data.getCli_codigo())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + data.getCli_codigo()));
            notaFiscalExistente.setCliente(cliente);
        }

        if (data.getFun_codigo() != null) {
            Funcionario funcionario = funcionarioRepository.findById(data.getFun_codigo())
                    .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + data.getFun_codigo()));
            notaFiscalExistente.setFuncionario(funcionario);
        }

        if (data.getNf_data_emissao() != null) {
            notaFiscalExistente.setNf_data_emissao(data.getNf_data_emissao());
        }

        if (data.getNf_total() != null) {
            notaFiscalExistente.setNf_total(data.getNf_total());
        }

        // Salva a nota fiscal atualizada
        Nf notaFiscalAtualizada = nfRepository.save(notaFiscalExistente);

        // Retorna a resposta com a nota fiscal atualizada
        return ResponseEntity.ok(notaFiscalAtualizada);
    }

    @DeleteMapping("remover/{id}")
    public ResponseEntity<String> excluirNotaFiscal(@PathVariable Integer id) {
        // Verifica se a nota fiscal existe
        Nf notaFiscal = nfRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota Fiscal não encontrada com o ID: " + id));

        // Exclui a nota fiscal
        nfRepository.delete(notaFiscal);

        // Retorna uma resposta de sucesso
        return ResponseEntity.ok("Nota Fiscal com ID " + id + " excluída com sucesso.");
    }

}
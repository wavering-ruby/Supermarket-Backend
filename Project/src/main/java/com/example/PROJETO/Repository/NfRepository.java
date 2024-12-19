package com.example.PROJETO.Repository;
import com.example.PROJETO.model.Nf;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NfRepository extends JpaRepository<Nf, Integer>{
     boolean existsByCliente_cliCodigo(Integer cli_codigo);

     boolean existsByFuncionario_funCodigo(Integer fun_codigo);
}
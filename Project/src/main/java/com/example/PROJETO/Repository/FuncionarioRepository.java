package com.example.PROJETO.Repository;

import com.example.PROJETO.DTO.FuncionarioporCargoDTO;
import com.example.PROJETO.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    //metodo de soma de funcionarios por cargo;
    @Query(value = "select fun_cargo as NomeCargo, COUNT(fun_codigo) as TotalFuncionarios  from Funcionario "
                    + "GROUP BY NomeCargo;",nativeQuery = true)
    List<FuncionarioporCargoDTO> FuncionarioporCargo();
}

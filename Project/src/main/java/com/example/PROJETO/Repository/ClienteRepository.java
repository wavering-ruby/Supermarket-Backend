package com.example.PROJETO.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.PROJETO.DTO.QuantidadeTotalCompra;
import com.example.PROJETO.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    @Query(value = "SELECT Cliente.cli_nome AS NomeCliente, SUM(Nf_total) AS TotalDeCompras FROM Nf " +
    "LEFT JOIN Cliente ON Cliente.cli_codigo = Nf.cli_codigo " +
    "GROUP BY Cliente.cli_nome; ", nativeQuery = true)
    List<QuantidadeTotalCompra> QuantidadeTotalCompra();
}
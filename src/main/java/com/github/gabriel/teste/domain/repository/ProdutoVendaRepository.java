package com.github.gabriel.teste.domain.repository;

import com.github.gabriel.teste.domain.entity.ProdutoVenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, Long> {
}

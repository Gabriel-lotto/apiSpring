package com.github.gabriel.teste.rest.controller;


import com.github.gabriel.teste.domain.entity.ProdutoVenda;
import com.github.gabriel.teste.rest.dto.InformacoesVendasDTO;
import com.github.gabriel.teste.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("venda")
public class VendaController {
    @Autowired
    private VendaService vendaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InformacoesVendasDTO> listarTodos() {
        return vendaService.listarTodos();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoVenda listarPorId(@PathVariable(name = "id") long id) {
        return vendaService.listarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long Inserir(@RequestBody ProdutoVenda venda) {
        return vendaService.inserirVenda(venda);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editarVenda(@PathVariable(name = "id") long id, @RequestBody ProdutoVenda venda) {
        vendaService.editarVenda(id, venda).orElseThrow(() -> new RuntimeException("cliente não encontrado"));
    }
}

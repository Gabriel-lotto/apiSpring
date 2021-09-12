package com.github.gabriel.teste.rest.controller;


import com.github.gabriel.teste.domain.entity.Venda;
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
    public List<Venda> listarTodos() {
        return vendaService.listarTodos();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Venda listarPorId(@PathVariable(name = "id") long id) {
        return vendaService.listarPorId(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long Inserir(@RequestBody Venda venda) {
        return vendaService.inserirVenda(venda);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarCliente(@PathVariable(name = "id") long id) {
        vendaService.deletarVenda(id).orElseThrow(() -> new RuntimeException(" venda não encontrada"));
    }
}

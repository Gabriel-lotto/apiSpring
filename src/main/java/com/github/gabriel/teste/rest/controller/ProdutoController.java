package com.github.gabriel.teste.rest.controller;


import com.github.gabriel.teste.domain.entity.Produto;
import com.github.gabriel.teste.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto listarPorId(@PathVariable(name="id") long id) {
        return produtoService.ListarPorId(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long inserir(@RequestBody Produto produto) {
        return produtoService.inserirProduto(produto);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editarProduto(@PathVariable(name = "id") long id, @RequestBody Produto produto) {
        produtoService.editarProduto(id, produto).orElseThrow(() -> new RuntimeException("produto não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarProduto(@PathVariable(name = "id") long id) {
        produtoService.deletarProduto(id).orElseThrow(() -> new RuntimeException("produto não encontrado"));
    }
}

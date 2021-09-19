package com.github.gabriel.teste.service;

import com.github.gabriel.teste.domain.entity.Produto;
import com.github.gabriel.teste.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> ListarPorId(long id){
        return produtoRepository.findById(id);
    }

    public Long inserirProduto(Produto produto) {
        System.out.println(produto.getNome());
        produtoRepository.save(produto);
        return produto.getId();
    }

    public Optional<Produto> editarProduto(long id, Produto produto) {
        return produtoRepository.findById(id)
                .map(prod -> {
                   prod.setNome(produto.getNome());
                   prod.setValor(produto.getValor());
                   produtoRepository.save(prod);
                   return produto;
                });
    }

    public Optional<Produto> deletarProduto(long id) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produtoRepository.delete(produto);
                    return produto;
                });
    }
}

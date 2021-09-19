package com.github.gabriel.teste.service;

import com.github.gabriel.teste.domain.entity.ProdutoVenda;
import com.github.gabriel.teste.domain.repository.ProdutoVendaRepository;
import com.github.gabriel.teste.domain.repository.VendaRepository;
import com.github.gabriel.teste.rest.dto.InformacoesVendasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;

    public List<InformacoesVendasDTO> listarTodos() {
        List<ProdutoVenda> produtosVendas = produtoVendaRepository.findAll();

        return converterProdutoVenda(produtosVendas);
    }

    private List<InformacoesVendasDTO> converterProdutoVenda(List<ProdutoVenda> produtosVendas) {
        List<InformacoesVendasDTO> infos = new ArrayList<>();

        String dataEntrega;

        for (ProdutoVenda produtovenda : produtosVendas) {
            dataEntrega = produtovenda.getVenda().getData().plusDays(10).toString();
            infos.add(new InformacoesVendasDTO(produtovenda.getVenda(), produtovenda.getProduto(), dataEntrega));
        }
        return infos;
    }

    public ProdutoVenda listarPorId(long id) {
        return produtoVendaRepository.findById(id).get();
    }

    public Long inserirVenda(ProdutoVenda venda){
        vendaRepository.save(venda.getVenda());
        produtoVendaRepository.save(venda);
        return venda.getId();
    }

    public Optional<ProdutoVenda> editarVenda(long id, ProdutoVenda venda) {
        Optional<ProdutoVenda> produtoVenda = produtoVendaRepository.findById(id);

        if(produtoVenda.isPresent()) {
            produtoVenda.get().setVenda(
                    vendaRepository.findById(produtoVenda.get().getVenda().getId()).map(venda1 -> {
                        venda1.setData(venda.getVenda().getData());
                        vendaRepository.save(venda1);
                        return venda1;
                    }).get()
            );
        } else {
            throw new RuntimeException("Venda não encontrada!");
        }
        return produtoVenda;
    }
}

package com.github.gabriel.teste.rest.dto;

import com.github.gabriel.teste.domain.entity.Produto;
import com.github.gabriel.teste.domain.entity.Venda;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformacoesVendasDTO {

    private Long id;
    private String dataVenda;
    private String dataEntrega;

    private Long idCliente;

    private Long idProduto;
    private String nomeProduto;
    private Double valorProduto;


    public InformacoesVendasDTO(Venda venda, Produto produto, String dataEntrega) {
        this.id = venda.getId();
        this.dataVenda = venda.getData().toString();
        this.idCliente = venda.getCliente().getId();
        this.idProduto = produto.getId();
        this.nomeProduto = produto.getNome();
        this.valorProduto = produto.getValor();
        this.dataEntrega = dataEntrega;
    }
}

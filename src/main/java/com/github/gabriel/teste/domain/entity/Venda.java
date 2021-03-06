package com.github.gabriel.teste.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.List;
import java.time.LocalDate;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="venda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="data")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "venda")
    private List<ProdutoVenda> produtovendas;
}
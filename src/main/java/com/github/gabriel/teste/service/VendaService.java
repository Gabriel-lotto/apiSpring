package com.github.gabriel.teste.service;

import com.github.gabriel.teste.domain.entity.Venda;
import com.github.gabriel.teste.domain.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> listarTodos() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> listarPorId(long id) {
        return vendaRepository.findById(id);
    }

    public Long inserirVenda(Venda venda){
//        System.out.println(venda.getId());
        vendaRepository.save(venda);
        return venda.getId();
    }

    public Optional<Venda> deletarVenda(long id) {
        return vendaRepository.findById(id)
                .map(venda -> {
                    vendaRepository.delete(venda);
                    return venda;
                });
    }
}

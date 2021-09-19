package com.github.gabriel.teste.service;

import com.github.gabriel.teste.domain.entity.Cliente;
import com.github.gabriel.teste.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos(){//lista todos os clientes do banco de dados
        return clienteRepository.findAll();
    }

    public Optional<Cliente> listarPorId(long id){//lista cliente pelo id
        return clienteRepository.findById(id);
    }

    public Long inserirCliente(Cliente cliente){
        System.out.println(cliente.getNome());
        clienteRepository.save(cliente);
        return cliente.getId();
    }

    public Optional<Cliente> editarCliente(long id, Cliente cliente) {
        return clienteRepository.findById(id)
                .map(cli -> {
                    cli.setNome(cliente.getNome());
                    cli.setCpfCnpj(cliente.getCpfCnpj());
                    clienteRepository.save(cli);
                    return cli;
                });
    }

    public Optional<Cliente> deletarCliente(long id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return cliente;
                });
    }
}
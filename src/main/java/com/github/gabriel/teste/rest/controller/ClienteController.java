package com.github.gabriel.teste.rest.controller;

import com.github.gabriel.teste.domain.entity.Cliente;
import com.github.gabriel.teste.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarTodos(){
        return clienteService.listarTodos();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente listarPorId(@PathVariable(name="id") long id){
        return clienteService.listarPorId(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long Inserir(@RequestBody Cliente cliente){
        return clienteService.inserirCliente(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarCliente(@PathVariable(name="id") long id) {
        clienteService.deletarCliente(id).orElseThrow(() -> new RuntimeException("cliente não encontrado"));
    }
}

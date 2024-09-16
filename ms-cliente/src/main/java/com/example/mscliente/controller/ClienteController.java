package com.example.mscliente.controller;

import com.example.mscliente.Service.ClienteService;
import com.example.mscliente.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(clienteService.listarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente Cliente) {
        return ResponseEntity.ok(clienteService.guardar(Cliente));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id,
                                           @RequestBody Cliente Cliente) {
        Cliente.setId(id);
        return ResponseEntity.ok(clienteService.guardar(Cliente));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Cliente>> delete(@PathVariable Integer id) {
        clienteService.eliminar(id);
        return ResponseEntity.ok(clienteService.listar());
    }
}

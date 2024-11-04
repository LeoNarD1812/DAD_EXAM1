package com.example.msevento.controller;

import com.example.msevento.service.CategoriaService;
import com.example.msevento.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(categoriaService.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.save(categoria));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Integer id,
                                           @RequestBody Categoria categoria) {
        categoria.setId(id);
        return ResponseEntity.ok(categoriaService.save(categoria));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Categoria>> delete(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.ok(categoriaService.list());
    }
}
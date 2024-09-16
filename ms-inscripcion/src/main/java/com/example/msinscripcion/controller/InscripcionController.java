package com.example.msinscripcion.controller;

import com.example.msinscripcion.entity.Inscripcion;
import com.example.msinscripcion.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public ResponseEntity<List<Inscripcion>> getAll() {
        return ResponseEntity.ok(inscripcionService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Inscripcion>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(inscripcionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Inscripcion> create(@RequestBody Inscripcion inscripcion) {
        return ResponseEntity.ok(inscripcionService.save(inscripcion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> update(@PathVariable Integer id,
                                        @RequestBody Inscripcion inscripcion) {
        inscripcion.setId(id);
        return ResponseEntity.ok(inscripcionService.save(inscripcion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Inscripcion>> delete(@PathVariable Integer id) {
        inscripcionService.delete(id);
        return ResponseEntity.ok(inscripcionService.list());
    }
}

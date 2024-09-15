package com.example.msevento.controller;

import com.example.msevento.Service.EventoService;
import com.example.msevento.entity.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> getAll() {
        return ResponseEntity.ok(eventoService.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Evento>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(eventoService.listarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Evento> create(@RequestBody Evento Evento) {
        return ResponseEntity.ok(eventoService.guardar(Evento));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Evento> update(@PathVariable Integer id,
                                           @RequestBody Evento Evento) {
        Evento.setId(id);
        return ResponseEntity.ok(eventoService.guardar(Evento));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Evento>> delete(@PathVariable Integer id) {
        eventoService.eliminar(id);
        return ResponseEntity.ok(eventoService.listar());
    }
}

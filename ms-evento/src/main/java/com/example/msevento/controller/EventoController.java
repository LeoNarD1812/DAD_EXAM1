package com.example.msevento.controller;

import com.example.msevento.service.EventoService;
import com.example.msevento.entity.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> getAll() {
        return ResponseEntity.ok(eventoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(eventoService.listarPorId(id).get());
    }
    @PostMapping
    public ResponseEntity<Evento> create(@RequestBody Evento evento) {
        return ResponseEntity.ok(eventoService.guardar(evento));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Evento> update(@PathVariable Integer id,
                                           @RequestBody Evento evento) {
        evento.setId(id);
        return ResponseEntity.ok(eventoService.guardar(evento));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Evento>> delete(@PathVariable Integer id) {
        eventoService.eliminar(id);
        return ResponseEntity.ok(eventoService.listar());
    }
}

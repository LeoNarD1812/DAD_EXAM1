package com.example.msevento.controller;

import com.example.msevento.service.EventService;
import com.example.msevento.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventController {
    @Autowired
    private EventService eventoService;

    @GetMapping
    public ResponseEntity<List<Event>> getAll() {
        return ResponseEntity.ok(eventoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(eventoService.listarPorId(id).get());
    }
    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event) {
        return ResponseEntity.ok(eventoService.guardar(event));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Event> update(@PathVariable Integer id,
                                        @RequestBody Event event) {
        event.setId(id);
        return ResponseEntity.ok(eventoService.guardar(event));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Event>> delete(@PathVariable Integer id) {
        eventoService.eliminar(id);
        return ResponseEntity.ok(eventoService.listar());
    }
}

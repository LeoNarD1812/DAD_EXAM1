package com.example.mspago.controller;

import com.example.mspago.entity.Pago;
import com.example.mspago.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pago")
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<Pago>> getAll(){return ResponseEntity.ok(pagoService.listar());}
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pago>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(pagoService.listarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Pago> create(@RequestBody Pago Pago) {
        return ResponseEntity.ok(pagoService.guardar(Pago));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pago> update(@PathVariable Integer id,
                                         @RequestBody Pago Pago) {
        Pago.setId(id);
        return ResponseEntity.ok(pagoService.guardar(Pago));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Pago>> delete(@PathVariable Integer id) {
        pagoService.eliminar(id);
        return ResponseEntity.ok(pagoService.listar());
    }
}

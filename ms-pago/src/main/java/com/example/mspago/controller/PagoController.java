package com.example.mspago.controller;

import com.example.mspago.entity.Transaccion;
import com.example.mspago.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pago")
public class PagoController {
    @Autowired
    private TransaccionService pagoService;

    @GetMapping
    public ResponseEntity<List<Transaccion>> getAll(){return ResponseEntity.ok(pagoService.listar());}
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Transaccion>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(pagoService.listarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Transaccion> create(@RequestBody Transaccion Pago) {
        return ResponseEntity.ok(pagoService.guardar(Pago));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Transaccion> update(@PathVariable Integer id,
                                              @RequestBody Transaccion Pago) {
        Pago.setId(id);
        return ResponseEntity.ok(pagoService.guardar(Pago));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Transaccion>> delete(@PathVariable Integer id) {
        pagoService.eliminar(id);
        return ResponseEntity.ok(pagoService.listar());
    }
}

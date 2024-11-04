package com.example.mspago.controller;

import com.example.mspago.dto.ClientDto;
import com.example.mspago.dto.ErrorResponseDto;
import com.example.mspago.dto.InscripcionDto;
import com.example.mspago.entity.Transaccion;
import com.example.mspago.entity.TransaccionDetalle;
import com.example.mspago.feign.ClientFeign;
import com.example.mspago.feign.InscripcionFeign;
import com.example.mspago.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pago")
public class TransaccionController {
    @Autowired
    private TransaccionService transaccionService;

    @Autowired
    private ClientFeign clientFeign;
    @Autowired
    private InscripcionFeign inscripcionFeign;

    @GetMapping
    public ResponseEntity<List<Transaccion>> getAll(){return ResponseEntity.ok(transaccionService.list());}

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Transaccion>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(transaccionService.findById(id));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Transaccion transaccion) {
        ClientDto clientDto = clientFeign.getById(transaccion.getClientId()).getBody();

        if (clientDto == null || clientDto.getId() == null) {
            String errorMessage = "Error: Cliente no encontrado.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(errorMessage));
        }
        for (TransaccionDetalle transaccionDetail : transaccion.getTransaccionDetalles()) {
            InscripcionDto productDto = inscripcionFeign.getById(transaccionDetail.getInscripcionId()).getBody();

            if (productDto == null || productDto.getId() == null) {
                String errorMessage = "Error: producto no encontrado.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(errorMessage));
            }
        }
        Transaccion newTransaccion = transaccionService.save(transaccion);
        return ResponseEntity.ok(newTransaccion);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Transaccion> update(@PathVariable Integer id,
                                              @RequestBody Transaccion transaccion) {
        transaccion.setId(id);
        return ResponseEntity.ok(transaccionService.save(transaccion));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Transaccion>> delete(@PathVariable Integer id) {
        transaccionService.delete(id);
        return ResponseEntity.ok(transaccionService.list());
    }
}

package com.example.msinscripcion.controller;

import com.example.msinscripcion.dto.ClientDto;
import com.example.msinscripcion.dto.ErrorResponseDto;
import com.example.msinscripcion.dto.EventDto;
import com.example.msinscripcion.entity.Inscripcion;
import com.example.msinscripcion.entity.InscripcionDetalle;
import com.example.msinscripcion.feign.ClientFeign;
import com.example.msinscripcion.feign.EventFeign;
import com.example.msinscripcion.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;
    @Autowired
    private ClientFeign clientFeign;
    @Autowired
    private EventFeign eventFeign;

    @GetMapping
    public ResponseEntity<List<Inscripcion>> getAll() {
        return ResponseEntity.ok(inscripcionService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Inscripcion>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(inscripcionService.findById(id));
    }

    @PostMapping

    public ResponseEntity<?> create(@RequestBody Inscripcion inscripcion) {
        ClientDto clientDto = clientFeign.getById(inscripcion.getClientId()).getBody();

        if (clientDto == null || clientDto.getId() == null) {
            String errorMessage = "Error: Cliente no encontrado.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(errorMessage));
        }
        for (InscripcionDetalle inscripcionDetalle : inscripcion.getInscripcionDetalles()) {
            EventDto eventDto = eventFeign.getById(inscripcionDetalle.getEventId()).getBody();

            if (eventDto == null || eventDto.getId() == null) {
                String errorMessage = "Error: Evento no encontrado.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(errorMessage));
            }
        }
        Inscripcion newInscripcion = inscripcionService.save(inscripcion);
        return ResponseEntity.ok(newInscripcion);
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

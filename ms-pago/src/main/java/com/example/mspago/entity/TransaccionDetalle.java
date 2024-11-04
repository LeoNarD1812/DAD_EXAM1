package com.example.mspago.entity;

import com.example.mspago.dto.InscripcionDetalleDto;
import com.example.mspago.dto.InscripcionDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class    TransaccionDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer InscripcionId;
    @Transient
    private InscripcionDto inscripcionDto;
    public TransaccionDetalle() {
    }
}

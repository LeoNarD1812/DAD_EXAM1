package com.example.mspago.dto;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class InscripcionDetalleDto {
    private Integer id;
    private Double precio;
    private Double cantidad;
    private Integer EventId;
}

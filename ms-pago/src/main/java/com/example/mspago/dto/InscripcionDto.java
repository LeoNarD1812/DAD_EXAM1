package com.example.mspago.dto;

import lombok.Data;

@Data
public class InscripcionDto {
    private Integer id;
    private String number;
    private InscripcionDetalleDto inscripcionDetalle;
}

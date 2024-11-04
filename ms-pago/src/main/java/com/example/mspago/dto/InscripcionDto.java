package com.example.mspago.dto;

import lombok.Data;

import java.util.List;

@Data
public class InscripcionDto {
    private Integer id;
    private String number;
    private InscripcionDetalleDto inscripcionDetalle;
}

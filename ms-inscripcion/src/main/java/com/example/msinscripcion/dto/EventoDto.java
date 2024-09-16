package com.example.msinscripcion.dto;

import lombok.Data;

@Data
public class EventoDto {
    private Integer id;
    private String name;
    private String description;
    private String code;
    private TipoEventoDto tipo;
}

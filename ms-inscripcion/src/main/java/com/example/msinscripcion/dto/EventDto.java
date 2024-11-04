package com.example.msinscripcion.dto;

import lombok.Data;

@Data
public class EventDto {
    private Integer id;
    private String name;
    private String description;
    private String code;
    private CategoriaDto categoria;
}

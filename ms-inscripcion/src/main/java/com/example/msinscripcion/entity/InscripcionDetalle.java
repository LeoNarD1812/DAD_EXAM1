package com.example.msinscripcion.entity;

import com.example.msinscripcion.dto.EventDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class InscripcionDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double precio;
    private Double cantidad;
    private Integer EventId;
    @Transient
    private EventDto eventDto;
    public InscripcionDetalle() {
        this.precio = (double) 0;
        this.cantidad= (double) 0;
    }
}

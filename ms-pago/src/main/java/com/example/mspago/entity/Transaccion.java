package com.example.mspago.entity;

import com.example.mspago.dto.ClientDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "transacciones")
public class Transaccion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    private Integer ClientId;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "transaccion_id")
    private List<TransaccionDetalle> transaccionDetalles;
    @Transient
    private ClientDto clientDto;
}

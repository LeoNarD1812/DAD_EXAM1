package com.example.msinscripcion.feign;


import com.example.msinscripcion.dto.EventoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "ms-evento-service", path = "/evento")
public interface EventoFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "eventoListByIdCB", fallbackMethod = "eventoListById")
    public ResponseEntity<EventoDto> getById(@PathVariable Integer id);
    default ResponseEntity<EventoDto> eventoListById(@PathVariable Integer id) {
        return ResponseEntity.ok(new EventoDto());
    }
}

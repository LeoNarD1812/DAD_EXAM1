package com.example.mspago.feign;

import com.example.mspago.dto.InscripcionDetalleDto;
import com.example.mspago.dto.InscripcionDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-inscripcion-service", path = "/inscripcion")
public interface InscripcionFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "inscripcionListByIdCB", fallbackMethod = "inscripcionListById")
    public ResponseEntity<InscripcionDto> getById(@PathVariable Integer id);
    default ResponseEntity<InscripcionDto> inscripcionListById(Integer id, Exception e) {
        return ResponseEntity.ok(new InscripcionDto());
    }
}

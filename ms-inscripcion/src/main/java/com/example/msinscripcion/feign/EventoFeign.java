package com.example.msinscripcion.feign;


import com.example.msinscripcion.dto.EventoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-evento-service", path = "/evento")
public interface EventoFeign {
    @GetMapping("/{id}")
    public ResponseEntity<EventoDto> getById(@PathVariable Integer id);
}

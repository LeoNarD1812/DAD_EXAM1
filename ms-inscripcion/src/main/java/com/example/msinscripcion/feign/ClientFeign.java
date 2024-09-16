package com.example.msinscripcion.feign;

import com.example.msinscripcion.dto.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cliente-service", path = "/cliente")
public interface ClientFeign {
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable Integer id);
}
